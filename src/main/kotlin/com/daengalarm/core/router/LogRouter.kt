package com.daengalarm.core.router

import com.daengalarm.core.handler.LogHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class LogRouter(private val handler: LogHandler) {
    @Bean
    fun eventLogRoute() =
        coRouter {
            "/api/v1/event".nest {
                listOf(
                    GET("/list", handler::findAll),
                    POST("", handler::addOne)
                )
            }
        }
}