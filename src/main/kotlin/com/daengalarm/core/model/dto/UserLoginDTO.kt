package com.daengalarm.core.model.dto

import com.daengalarm.core.model.enums.LoginType

data class UserLoginDTO(
    val username: String,
    val password: String,
    val loginPin: String? = null,
    val loginType: LoginType = LoginType.DEFAULT
)
