package com.daengalarm.core.service

import com.daengalarm.core.entity.User
import com.daengalarm.core.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(private val userRepository: UserRepository) {

    fun login(param: User): Mono<User> {
        return userRepository.findByUsernameAndPassword(param.username, param.password)
    }
}