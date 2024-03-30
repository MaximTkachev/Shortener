package ru.qwerty.shortener.core.service

interface ShorteningService {

    fun get(link: String): String

    fun create(link: String): String
}
