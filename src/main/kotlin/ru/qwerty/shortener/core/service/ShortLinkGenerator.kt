package ru.qwerty.shortener.core.service

interface ShortLinkGenerator {

    fun generate(): String
}