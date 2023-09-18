package com.daengalarm.core.entity

import com.daengalarm.core.entity.converter.LoginTypeConverter
import com.daengalarm.core.entity.enums.LoginType
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime


@Table(name = "user_mng")
class UserMng {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long = 0;

    @Column(name = "username", nullable = false)
    var username: String? = null;

    @Column(name = "password", nullable = false)
    var password: String? = null;

    @Column(name = "login_pin")
    var loginPin: String? = null;   // TODO : 마지막 접속 디바이스에 대한 간편비밀번호 저장 ?

    @Column(name = "login_type")
    @Convert(converter = LoginTypeConverter::class)
    var loginType: LoginType = LoginType.DEFAULT;

    @CreatedDate
    @Column(name = "created_at")
    private val createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "modified_at")
    private val modifiedAt: LocalDateTime? = createdAt
}