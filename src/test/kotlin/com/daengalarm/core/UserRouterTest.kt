package com.daengalarm.core

import com.daengalarm.core.handler.UserHandler
import com.daengalarm.core.router.UserRouter
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@WebFluxTest(UserRouter::class)
class UserRouterTest() {
    @Autowired
    private lateinit var webclient: WebTestClient

    @MockBean
    private lateinit var userHandler: UserHandler


    @Test
    fun testLogin() {

    }

}