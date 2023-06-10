package ru.qwerty.shortener.repository.implement

import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service
import ru.qwerty.shortener.repository.SequenceGenerator

@Service
class DefaultSequenceGenerator(private val manager: EntityManager): SequenceGenerator {

    override fun nextValue(): Long {
        return manager.createQuery("select nextval('short_link_seq')").singleResult as Long
    }
}
