package com.petlender.core.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/api/v1/login")
class LoginController {

    @PostMapping("/user")
    fun loginUser(): String {
        return "Success"
    }

}