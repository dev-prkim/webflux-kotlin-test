package com.daengalarm.core.model.setting

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
//@EntityListeners(AuditingEntityListener::class)
open class BaseTime {
    @CreatedDate
    @Column(name = "created_at")
    private val createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "modified_at")
    private val modifiedAt: LocalDateTime? = createdAt
}