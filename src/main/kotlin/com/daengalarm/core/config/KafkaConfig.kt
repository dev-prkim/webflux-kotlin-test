package com.daengalarm.core.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {
    @Bean
    fun createUserLoginLogTopic(): NewTopic {
        return TopicBuilder.name(KafkaTopicConstants.LOGIN_LOG_TOPIC).build()
    }
}