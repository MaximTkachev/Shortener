package ru.qwerty.shortener.util.implement

import org.springframework.stereotype.Component
import ru.qwerty.shortener.repository.SequenceGenerator
import ru.qwerty.shortener.util.ShortLinkGenerator

@Component
class DefaultShortLinkGenerator(private val sequenceGenerator: SequenceGenerator): ShortLinkGenerator {

    override fun generate(): String {
        return Integer.toHexString(sequenceGenerator.nextValue().toInt())
    }
}
