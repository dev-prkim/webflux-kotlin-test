package com.daengalarm.core.model.dto

import com.daengalarm.core.model.entity.User
import com.daengalarm.core.model.enums.LoginType
import java.time.LocalDateTime

data class UserJoinDTO(
    val username: String,
    val password: String,
    val email: String,
    val loginPin: String ?= null,
    val loginType: LoginType = LoginType.DEFAULT,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val modifiedAt: LocalDateTime = createdAt
)

fun UserJoinDTO.toModel(withId: Long? = null) =
    User(
        withId,
        this.username,
        this.password,
        this.email,
        this.loginPin,
        this.loginType,
        this.createdAt,
        this.modifiedAt
    )