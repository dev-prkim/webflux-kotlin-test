package com.daengalarm.core.router

import com.daengalarm.core.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.coRouter
import org.springframework.web.reactive.function.server.router

@Configuration
class UserRouter(private val handler: UserHandler) {

    @Bean
    fun userRoute() =
        coRouter  {
            "/api/v1/user".nest {
                listOf(
                    POST("/login", handler::login),
                    POST("/join", handler::join),
                    GET("", handler::findAll),
                    GET("/search", handler::search)
                )
            }
        }

}