package com.example.github.configuration

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class GoodbyeWorldChatterbox {
    @Scheduled(fixedDelay = 60_000)
    fun blabberGoodbyeWorld() {
        logger.info("Goodbye, world!")
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(GoodbyeWorldChatterbox::class.java)
    }
}