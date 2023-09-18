package com.daengalarm.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class DaengAlarmCoreApplication

fun main(args: Array<String>) {
    runApplication<DaengAlarmCoreApplication>(*args)
}
