package ru.qwerty.shortener.service.implement

import org.springframework.stereotype.Service
import ru.qwerty.shortener.service.ShorteningService

@Service
class DefaultShorteningService: ShorteningService {

    override fun get(link: String): String {
        return "https://www.google.com/"
    }

    override fun create(link: String): String {
        return "ABC123"
    }
}
