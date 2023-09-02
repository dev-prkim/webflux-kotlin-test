package com.daengalarm.core.repository

import com.daengalarm.core.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByUsernameAndPassword(username: String?, password: String?): Mono<User>
}