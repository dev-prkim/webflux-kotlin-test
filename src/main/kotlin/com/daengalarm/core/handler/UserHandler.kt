package com.daengalarm.core.handler

import com.daengalarm.core.model.dto.UserDTO
import com.daengalarm.core.model.entity.User
import com.daengalarm.core.repository.UserRepository
import com.daengalarm.core.service.UserService
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class UserHandler(val service: UserService) {
    private val log = LoggerFactory.getLogger(UserHandler::class.java)

    suspend fun findAll(request: ServerRequest): ServerResponse {
        val users = service.findAll()
        return ServerResponse.ok().json().bodyAndAwait(users)
    }

    suspend fun search(request: ServerRequest): ServerResponse {
        val criterias = request.queryParams()
        return when {
            criterias.isEmpty() -> ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("Search must have query params"))
            criterias.contains("loginPin") -> {
                val criteriaValue = criterias.getFirst("loginPin")
                if (criteriaValue.isNullOrBlank()) {
                    ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("Incorrect search criteria value"))
                } else {
                    ServerResponse.ok().json().bodyAndAwait(service.findByLoginPin(criteriaValue))
                }
            }
            else -> ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("Incorrect search criteria"))
        }
    }

    suspend fun login(request: ServerRequest): ServerResponse {
        val param = try {
            request.bodyToMono<UserDTO>().awaitFirstOrNull()
        } catch (e: Exception) {
            log.error("Decoding body error", e)
            null
        }

        return if (param?.username == null || param?.password == null) {
            ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("`id` must be numeric"))
        } else {
            val user = service.login(param?.username, param?.password)
            if (user == null) ServerResponse.notFound().buildAndAwait()
            else ServerResponse.ok().json().bodyValueAndAwait(user)
        }

    }

    fun join(req: ServerRequest) : Mono<ServerResponse> = ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(req.bodyToMono(User::class.java)
            .flatMap { user ->
                Mono.fromCallable {
                    repo.save(user)
                }.then(Mono.just(user))
            }
        ).switchIfEmpty(notFound().build())

    fun getAll(req: ServerRequest) : Mono<ServerResponse> = ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body<List<User>>(Mono.just(repo.findAll()))
        .switchIfEmpty(notFound().build())
}
