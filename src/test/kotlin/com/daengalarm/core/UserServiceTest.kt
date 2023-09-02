package com.daengalarm.core

import com.daengalarm.core.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UserServiceTest(private val userRepository: UserRepository) {

    @Test
    fun login() {

    }
}