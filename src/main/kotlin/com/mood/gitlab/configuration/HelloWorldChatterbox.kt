package com.mood.gitlab.configuration

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class HelloWorldChatterbox {
    @Scheduled(fixedDelay = 600000)
    fun grumbleHelloWorld() {
        logger.info("Hello, world!")
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(HelloWorldChatterbox::class.java)
    }
}