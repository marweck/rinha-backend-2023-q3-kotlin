package com.hugomarques.rinhabackend2023.pessoas

import org.springframework.cache.annotation.CacheConfig
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@CacheConfig(cacheNames = ["PessoasCache"])
class PessoaController(
    private val repository: PessoaRepository,
    private val pessoaAsyncService: PessoaAsyncService,
    private val cache: RedisTemplate<String?, Pessoa?>
) {

    /**
     * Returns 201 for success and 401 if there's already a person with that same nickname.
     * 400 for invalid requests.
     */
    @PostMapping("/pessoas")
    fun newPessoa(@RequestBody pessoa: Pessoa): ResponseEntity<Pessoa> {
        if (cache.opsForValue()[pessoa.apelido!!] != null) {
            return ResponseEntity.unprocessableEntity().build()
        }

        pessoa.id = UUID.randomUUID()
        cache.opsForValue()[pessoa.apelido!!] = pessoa
        cache.opsForValue()[pessoa.id.toString()] = pessoa
        pessoaAsyncService.insert(pessoa)

        return ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED)
    }

    /**
     * 200 for OK
     * 404 for not found.
     */
    @GetMapping("/pessoas/{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<Pessoa> {
        val cached = cache.opsForValue()[id.toString()]

        return if (cached != null) {
            ResponseEntity.ok(cached)
        } else ResponseEntity.ok(
            repository.findById(id).orElseThrow { PessoaNotFoundException(id) }
        )
    }

    @GetMapping("/pessoas")
    fun findAllBySearchTerm(@RequestParam(name = "t") term: String): ResponseEntity<List<Pessoa>> =
        if (!StringUtils.hasText(term)) {
            ResponseEntity.badRequest().build()
        } else {
            ResponseEntity.ok(repository.findAllByTerm(term))
        }


    @GetMapping("/contagem-pessoas")
    fun count(): ResponseEntity<String> =
        ResponseEntity.ok(repository.count().toString())
}