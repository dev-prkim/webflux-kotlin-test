package com.daengalarm.core

import com.daengalarm.core.entity.User
import com.daengalarm.core.repository.UserRepository
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono

class UserService(val userRepository: UserRepository) {

    @Test
    fun login() {
        userRepository.findByUsernameAndPassword("test", "1234")
    }
}