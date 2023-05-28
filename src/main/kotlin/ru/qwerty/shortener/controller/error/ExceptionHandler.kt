package ru.qwerty.shortener.controller.error

import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@Slf4j
@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun handle(exception: Exception): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
