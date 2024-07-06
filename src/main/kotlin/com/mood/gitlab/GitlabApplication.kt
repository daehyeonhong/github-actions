package com.mood.gitlab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GitlabApplication

fun main(args: Array<String>) {
    runApplication<GitlabApplication>(*args)
}
