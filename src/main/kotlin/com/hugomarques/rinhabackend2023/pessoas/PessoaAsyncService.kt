package com.hugomarques.rinhabackend2023.pessoas

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class PessoaAsyncService(
    private val repository: PessoaRepository
) {

    @Async
    fun insert(pessoa: Pessoa) {
        repository.save(pessoa)
    }
}
