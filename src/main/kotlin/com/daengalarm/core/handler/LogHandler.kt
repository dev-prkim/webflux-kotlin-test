package com.daengalarm.core.handler

import com.daengalarm.core.config.KafkaTopicConstants
import com.daengalarm.core.model.entity.EventLog
import com.daengalarm.core.service.EventLogService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import java.time.LocalDateTime

@Component
class LogHandler(val service: EventLogService) {
    private val log = LoggerFactory.getLogger(LogHandler::class.java)

    suspend fun findAll(request: ServerRequest): ServerResponse {
        val logs = service.findAll()
        return ok().bodyAndAwait(logs)
    }

    suspend fun addOne(request: ServerRequest): ServerResponse {
        service.addLog(EventLog(
            null,
            "Test",
            "Test",
            LocalDateTime.now()
        ))
        return ok().bodyValueAndAwait("ok")
    }
}