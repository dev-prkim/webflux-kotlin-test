package com.daengalarm.core.repository

import com.daengalarm.core.model.entity.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveCrudRepository<User, Long> {

    fun findByUsernameAndPassword(username: String, password: String): Flux<User>
    fun findByLoginPin(loginPin: String): Flux<User>
}