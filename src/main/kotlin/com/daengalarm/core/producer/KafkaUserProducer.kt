package com.daengalarm.core.producer

import com.daengalarm.core.config.KafkaTopicConstants
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class KafkaUserProducer(val kafkaTemplate: KafkaTemplate<String, String>) {
    fun sendMessageLoginLog(message: String) {
        val now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())
        kafkaTemplate.send(KafkaTopicConstants.LOGIN_LOG_TOPIC, "[$now] $message")
    }
}