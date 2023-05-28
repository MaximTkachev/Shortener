package ru.qwerty.shortener.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.qwerty.shortener.model.ShortenLinkResponse
import ru.qwerty.shortener.service.ShorteningService

@RestController
@RequestMapping("/api/v1")
class ShorteningController(private val service: ShorteningService) {

    @PostMapping
    fun shorten(@RequestParam link: String): ShortenLinkResponse {
        return ShortenLinkResponse(service.create(link))
    }
}
