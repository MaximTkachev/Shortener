package ru.qwerty.shortener.core.service

import ru.qwerty.shortener.model.ShortenLinkResponse

interface ShorteningService {

    fun get(link: String): String

    fun create(link: String): ShortenLinkResponse
}
