package com.petlender.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class PetlenderCoreApplication

fun main(args: Array<String>) {
    runApplication<PetlenderCoreApplication>(*args)
}
