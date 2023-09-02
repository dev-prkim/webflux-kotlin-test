package com.daengalarm.core.entity.setting

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import lombok.Getter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Getter
@MappedSuperclass // 부모 클래스로 선언 (자식 클래스는 해당 클래스의 필드를 Colunm 으로 생성)
@EntityListeners(AuditingEntityListener::class)
open class BaseTime {
    @CreatedDate
    @Column(name = "created_at")
    private val createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "modified_at")
    private val modifiedAt: LocalDateTime? = createdAt
}