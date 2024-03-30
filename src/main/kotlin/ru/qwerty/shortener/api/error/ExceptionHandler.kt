package ru.qwerty.shortener.api.error

import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.qwerty.shortener.exception.ServiceException

@Slf4j
@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun handle(exception: Exception): ResponseEntity<Unit> {
        if (exception is ServiceException) {
            return ResponseEntity(exception.getStatus())
        }

        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
