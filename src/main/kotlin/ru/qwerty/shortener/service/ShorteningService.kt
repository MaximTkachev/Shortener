package ru.qwerty.shortener.service

interface ShorteningService {

    fun get(link: String): String

    fun create(link: String): String
}
