package ru.qwerty.shortener.core.service.implement

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.qwerty.shortener.config.AppProperties
import ru.qwerty.shortener.core.repository.LinkRepository
import ru.qwerty.shortener.core.repository.entity.LinkEntity
import ru.qwerty.shortener.core.service.ShortLinkGenerator
import ru.qwerty.shortener.core.service.ShorteningService
import ru.qwerty.shortener.exception.NotFoundException
import ru.qwerty.shortener.model.ShortenLinkResponse
import java.util.Date

@Service
class DefaultShorteningService(
    private val properties: AppProperties,
    private val repository: LinkRepository,
    private val generator: ShortLinkGenerator
) : ShorteningService {

    @Transactional
    override fun get(link: String): String {
        val entity = repository.findByShortLink(link)
            .orElseThrow { NotFoundException() }
        entity.lastUseDate = Date()
        entity.usesCount++

        return entity.originalLink
    }

    @Transactional
    override fun create(link: String): ShortenLinkResponse {
        val shortLink = generator.generate()
        repository.save(LinkEntity(shortLink = shortLink, originalLink = link))

        return ShortenLinkResponse(properties.host + "/" + shortLink)
    }
}
