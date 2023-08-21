package com.hugomarques.rinhabackend2023.config

import com.hugomarques.rinhabackend2023.pessoas.Pessoa
import com.hugomarques.rinhabackend2023.pessoas.PessoaRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner

//@Configuration
class LoadDatabase {
    //@Bean
    fun initDatabase(repository: PessoaRepository): CommandLineRunner =
        CommandLineRunner { _ ->
            log.info(
                "Preloading " + repository.save(
                    Pessoa("Bilbo Baggins", "burglar", "1970-01-01", listOf("Java"))
                )
            )
            log.info(
                "Preloading " + repository.save(
                    Pessoa("Frodo Baggins", "thief", "1985-01-01", listOf("C#"))
                )
            )
        }

    companion object {
        private val log = LoggerFactory.getLogger(LoadDatabase::class.java)
    }
}
