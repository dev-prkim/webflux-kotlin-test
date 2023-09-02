package com.daengalarm.core.router

import com.daengalarm.core.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class UserRouter(private val handler: UserHandler) {

    @Bean
    fun routerFunction() = nest(path("/api/v1/user"),
        router {
            listOf(
                POST("/login", handler::login)
            )
        }
    )

}