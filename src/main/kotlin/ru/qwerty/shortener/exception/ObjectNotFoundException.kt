package ru.qwerty.shortener.exception

import org.springframework.http.HttpStatus

class ObjectNotFoundException: ServiceException(HttpStatus.NOT_FOUND)
