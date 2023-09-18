package com.daengalarm.core.repository

import com.daengalarm.core.entity.UserMng
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

import reactor.core.publisher.Mono

@Repository
public interface UserRepository : ReactiveCrudRepository<UserMng, Long> {

    public fun findByUsernameAndPassword(username: String?, password: String?): Mono<UserMng>
}