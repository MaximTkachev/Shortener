package ru.qwerty.shortener.util

import org.springframework.stereotype.Component

@Component
class ShortLinkGenerator {

    private var x = 0

    fun generate(): String {
        x++
        return x.toString()
    }
}
