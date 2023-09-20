package com.daengalarm.core.model.dto

import com.daengalarm.core.model.entity.User
import com.daengalarm.core.model.enums.LoginType
import java.time.LocalDateTime

data class UserDTO(
    val username: String,
    val password: String,
    val loginPin: String,
    val loginType: LoginType,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime
)

fun UserDTO.toModel(withId: Long? = null) =
    User(withId, this.username, this.password, this.loginPin, this.loginType, this.createdAt, this.modifiedAt)