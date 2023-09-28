package com.daengalarm.core.model.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "event_log")
data class EventLog(
    @Id
    val idx: Long? = null,
    val message: String,
    val topic: String,
    @CreatedDate
    @Column("created_at")
    val createdAt: LocalDateTime,
)