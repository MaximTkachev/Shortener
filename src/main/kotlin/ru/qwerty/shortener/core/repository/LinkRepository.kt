package ru.qwerty.shortener.core.repository

import org.springframework.data.repository.CrudRepository
import ru.qwerty.shortener.core.repository.entity.LinkEntity
import java.util.Optional

@SuppressWarnings("kotlin:S6517")
interface LinkRepository : CrudRepository<LinkEntity, Long> {

    fun findByShortLink(link: String): Optional<LinkEntity>
}
