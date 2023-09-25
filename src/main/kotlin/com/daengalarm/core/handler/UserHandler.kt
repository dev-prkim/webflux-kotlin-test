package com.daengalarm.core.handler

import com.daengalarm.core.model.dto.UserJoinDTO
import com.daengalarm.core.model.dto.UserLoginDTO
import com.daengalarm.core.model.enums.ErrorMessage
import com.daengalarm.core.service.UserService
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.*

@Component
class UserHandler(val service: UserService) {
    private val log = LoggerFactory.getLogger(UserHandler::class.java)

    suspend fun findAll(request: ServerRequest): ServerResponse {
        val users = service.findAll()
        return ok().json().bodyAndAwait(users)
    }

    suspend fun search(request: ServerRequest): ServerResponse {
        val criterias = request.queryParams()
        return when {
            criterias.isEmpty() -> badRequest().json()
                .bodyValueAndAwait(ErrorMessage.SEARCH_QUERY_PARAM_NOT_FOUND)

            criterias.contains("email") -> {
                val criteriaValue = criterias.getFirst("email")
                if (criteriaValue.isNullOrBlank()) {
                    badRequest().json().bodyValueAndAwait(ErrorMessage.INCORRECT_SEARCH_CRITERIA_VALUE)
                } else {
                    ok().json().bodyAndAwait(service.findByEmail(criteriaValue))
                }
            }

            else -> badRequest().json().bodyValueAndAwait(ErrorMessage.INCORRECT_SEARCH_CRITERIA)
        }
    }

    suspend fun login(request: ServerRequest): ServerResponse {
        val param = try {
            request.bodyToMono<UserLoginDTO>().awaitFirstOrNull()
        } catch (e: Exception) {
            log.error("Decoding body error", e)
            null
        }

        return if (param?.username == null || param?.password == null) {
            badRequest().json().bodyValueAndAwait(ErrorMessage.DATA_TYPE_ERROR_ID)
        } else {
            val user = service.login(param.username, param.password)
            if (user == null) notFound().buildAndAwait()
            else ok().json().bodyValueAndAwait(user)
        }

    }

    suspend fun join(request: ServerRequest): ServerResponse {
        val newUser = try {
            request.bodyToMono<UserJoinDTO>().awaitFirstOrNull()
        } catch (e: Exception) {
            log.error("Decoding body error", e)
            null
        }
        return if (newUser == null) {
            badRequest().json().bodyValueAndAwait(ErrorMessage.INVALID_BODY)
        } else {
            val user = service.addOne(newUser)
            if (user == null) status(HttpStatus.INTERNAL_SERVER_ERROR).json()
                .bodyValueAndAwait(ErrorMessage.INTERNAL_ERROR)
            else status(HttpStatus.CREATED).json().bodyValueAndAwait(user)
        }
    }

}
