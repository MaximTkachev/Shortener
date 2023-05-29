package ru.qwerty.shortener.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
@Table(name = "link")
class LinkEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true)
    val shortLink: String,

    @Column
    val originalLink: String,

    @Temporal(TemporalType.DATE)
    val creationDate: Date = Date(),

    @Temporal(TemporalType.DATE)
    var lastUseDate: Date = Date(),

    var usesCount: Int = 0
)
