package com.daengalarm.core.service

import com.daengalarm.core.model.dto.UserJoinDTO
import com.daengalarm.core.model.dto.UserLoginDTO
import com.daengalarm.core.model.dto.toModel
import com.daengalarm.core.repository.UserRepository
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val repo: UserRepository) {
    suspend fun findAll() = repo.findAll().asFlow()
    suspend fun login(userName: String, password: String) = repo.findByUsernameAndPassword(userName, password).awaitFirstOrNull()
    suspend fun findByEmail(loginPin: String) = repo.findByEmail(loginPin).asFlow()
    suspend fun addOne(user: UserJoinDTO) = repo.save(user.toModel()).awaitFirstOrNull()
}