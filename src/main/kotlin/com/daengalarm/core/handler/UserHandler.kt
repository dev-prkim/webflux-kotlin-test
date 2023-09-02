package com.daengalarm.core.handler

import com.daengalarm.core.entity.User
import com.daengalarm.core.service.UserService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class UserHandler(private val userService: UserService) {

    fun login(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(User::class.java)
            .flatMap { user ->
                userService.login(user)
                    .flatMap { loggedInUser ->
                        ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromValue(loggedInUser))
                    }
                    .switchIfEmpty(notFound().build()) // 사용자를 찾지 못한 경우 404 응답
            }
    }
}
