package com.hugomarques.rinhabackend2023.config

import com.hugomarques.rinhabackend2023.pessoas.Pessoa
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class CacheConfig {

    @Bean
    fun redisTemplate(factory: RedisConnectionFactory?): RedisTemplate<String, Pessoa> =
        RedisTemplate<String, Pessoa>().apply {
            connectionFactory = factory
        }
}
