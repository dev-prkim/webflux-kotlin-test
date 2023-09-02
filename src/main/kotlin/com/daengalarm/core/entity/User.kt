package com.daengalarm.core.entity

import com.daengalarm.core.entity.converter.LoginTypeConverter
import com.daengalarm.core.entity.enums.LoginType
import com.daengalarm.core.entity.setting.BaseTime
import jakarta.persistence.*

@Entity
@Table(name = "user")
class User : BaseTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long = 0;

    @Column(name = "username", nullable = false)
    var username: String? = null;

    @Column(name = "password", nullable = false)
    var password: String? = null;

    @Column(name = "login_pin")
    var loginPin: String? = null;   // TODO : 마지막 접속 디바이스에 대한 간편비밀번호 저장 ?

    @Column(name = "loginType")
    @Convert(converter = LoginTypeConverter::class)
    var loginType: LoginType = LoginType.DEFAULT;

}