package ru.qwerty.shortener.exception

import org.springframework.http.HttpStatus

open class ServiceException protected constructor(private val code: HttpStatus) : RuntimeException() {

    fun getStatus(): HttpStatus {
        return code
    }
}
