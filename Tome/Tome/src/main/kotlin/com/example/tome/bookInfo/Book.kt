package com.example.tome.bookInfo

import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfo.language.Language
import com.example.tome.bookInfo.publisher.Publisher
import com.example.tome.bookInfo.tags.Tags
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val title: String = "",
    val isbn: String = "",
    val releaseDate: String = "",
    val pages: String = "",
    @Column(name = "coverUrl")
    val url: String = "",
    @Column(columnDefinition = "TEXT")
    val synopsis: String = "",
    val language: Language = Language.NULL,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_author",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")],
    )
    val authors: List<Author>? = emptyList(),
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    val publisher: Publisher? = null,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "book_tags",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "tags_id")],
    )
    val tags: List<Tags>? = emptyList(),
)
