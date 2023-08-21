package com.hugomarques.rinhabackend2023

import org.springframework.boot.runApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.scheduling.annotation.EnableAsync

@[SpringBootApplication EnableCaching EnableAsync]
class RinhaBackend2023Application

fun main(args: Array<String>) {
    runApplication<RinhaBackend2023Application>(*args)
}
