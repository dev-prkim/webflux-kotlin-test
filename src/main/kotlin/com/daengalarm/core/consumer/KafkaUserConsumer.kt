package com.daengalarm.core.consumer

import com.daengalarm.core.config.KafkaTopicConstants
import com.daengalarm.core.model.entity.EventLog
import com.daengalarm.core.service.EventLogService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class KafkaUserConsumer(private val service: EventLogService) {
    @KafkaListener(topics = [KafkaTopicConstants.LOGIN_LOG_TOPIC])
    fun listen(message: String) {
        print("Message Received - $message")

        // 비동기로 DB 저장
        CoroutineScope(Dispatchers.Default).launch {
            service.addLog(EventLog(
                null,
                message,
                KafkaTopicConstants.LOGIN_LOG_TOPIC,
                LocalDateTime.now()
            ))
        }
    }
}
