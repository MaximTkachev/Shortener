package ru.qwerty.shortener.exception

import org.springframework.http.HttpStatus

class NotFoundException : ServiceException(HttpStatus.NOT_FOUND)
