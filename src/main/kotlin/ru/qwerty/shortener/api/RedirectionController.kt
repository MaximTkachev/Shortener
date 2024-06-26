package ru.qwerty.shortener.api

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.qwerty.shortener.core.service.ShorteningService

@RestController
class RedirectionController(private val service: ShorteningService) {

    @GetMapping("/{link}")
    fun redirect(@PathVariable link: String, response: HttpServletResponse): ResponseEntity<Unit> {
        response.addHeader(HttpHeaders.LOCATION, service.get(link))
        return ResponseEntity<Unit>(HttpStatus.PERMANENT_REDIRECT)
    }
}
