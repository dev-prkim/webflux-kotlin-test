package com.daengalarm.core.service

import com.daengalarm.core.model.entity.EventLog
import com.daengalarm.core.repository.EventLogRepository
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EventLogService(private val repo: EventLogRepository) {
    suspend fun addLog(log: EventLog) = repo.save(log).awaitFirstOrNull()
    suspend fun findAll() = repo.findAll().asFlow()
}