package ru.qwerty.shortener.core.service.implement

import org.springframework.stereotype.Service
import ru.qwerty.shortener.core.service.ShortLinkGenerator
import java.util.concurrent.atomic.AtomicLong

@Service
class DefaultShortLinkGenerator : ShortLinkGenerator {

    private val counter: AtomicLong = AtomicLong(1)

    private val basis = 36

    private val numericSummand = '0'.code

    private val characterSummand = 'a'.code - 10L

    override fun generate(): String {
        var value = counter.getAndIncrement()
        val stringBuilder: StringBuilder = StringBuilder()

        while (value > 0) {
            stringBuilder.append(convert(value % basis))
            value /= basis
        }

        return stringBuilder.toString()
    }

    fun convert(value: Long): Char {
        val temp = if (value < 10) value + numericSummand else value + characterSummand
        return temp.toInt().toChar()
    }
}
