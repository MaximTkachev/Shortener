package ru.qwerty.shortener.repository

interface SequenceGenerator {

    fun nextValue(): Long
}
