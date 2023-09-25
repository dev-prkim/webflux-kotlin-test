package com.daengalarm.core.model.entity

import com.daengalarm.core.model.enums.LoginType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "users")
data class User(
    @Id
    val idx: Long? = null,
    val username: String,
    val password: String,
    val email: String,
    @Column("login_pin")
    val loginPin: String? = null,
    @Column("login_type")
//    @Convert(converter = LoginTypeConverter::class)
    val loginType: LoginType = LoginType.DEFAULT,
    @CreatedDate
    @Column("created_at")
    val createdAt: LocalDateTime,
    @LastModifiedDate
    @Column("modified_at")
    val modifiedAt: LocalDateTime? = createdAt
)