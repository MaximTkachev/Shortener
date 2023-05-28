package ru.qwerty.shortener.service.implement

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.qwerty.shortener.repository.LinkRepository
import ru.qwerty.shortener.repository.entity.LinkEntity
import ru.qwerty.shortener.service.ShorteningService
import ru.qwerty.shortener.util.ShortLinkGenerator
import java.util.Date

@Service
class DefaultShorteningService(
    private val repository: LinkRepository,
    private val generator: ShortLinkGenerator
): ShorteningService {

    @Transactional
    override fun get(link: String): String {
        val entity = repository.findByShortLink(link).orElseThrow()
        entity.lastUseDate = Date()
        entity.usesCount++

        return entity.originalLink
    }

    @Transactional
    override fun create(link: String): String {
        val shortLink = generator.generate()
        repository.save(LinkEntity(shortLink = shortLink, originalLink = link))

        return shortLink
    }
}
