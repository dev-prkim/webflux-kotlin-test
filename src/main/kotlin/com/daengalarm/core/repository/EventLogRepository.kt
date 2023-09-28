package com.daengalarm.core.repository

import com.daengalarm.core.model.entity.EventLog
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EventLogRepository : ReactiveCrudRepository<EventLog, Long> {
}