package com.daengalarm.core.service

import com.daengalarm.core.model.dto.UserDTO
import com.daengalarm.core.model.dto.toModel
import com.daengalarm.core.repository.UserRepository
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val repo: UserRepository) {
    suspend fun findAll() = repo.findAll().asFlow()
    suspend fun login(userName: String, password: String) = repo.findByUsernameAndPassword(userName, password).awaitFirstOrNull()
    suspend fun findByLoginPin(loginPin: String) = repo.findByLoginPin(loginPin).asFlow()
    suspend fun addOne(user: UserDTO) = repo.save(user.toModel()).awaitFirstOrNull()
}