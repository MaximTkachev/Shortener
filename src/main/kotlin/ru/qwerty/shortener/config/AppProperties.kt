package ru.qwerty.shortener.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application")
data class AppProperties(val host: String)
