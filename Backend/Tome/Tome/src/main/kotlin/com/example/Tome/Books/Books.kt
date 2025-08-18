package com.example.Tome.Books

import com.example.Tome.Books.BookAuthors.Authors
import com.example.Tome.Books.BooksTags.Tags
import com.example.Tome.Books.Publishers.Publishers
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "Books")
class Books(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var book_id: Long = 0,
    @Column()
    var title: String = "",
    @Column
    var isbn: String = "",
    @Column
    var releaseDate: String = "",
    @Column
    var pages: String = "",
    @Column(name = "CoverURL")
    var url: String = "",
    @Column
    var synopsis: String = "",
    @Column
    var language: String = "",

    @ManyToOne
    @JoinColumn(name = "publisher_id",)
    var publisher: Publishers,

    @ManyToMany
    @JoinTable(name = "book_authors",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
        )
    var authors: MutableList<Authors> = mutableListOf(),

    @ManyToMany
    @JoinTable(name = "book_tags",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "tags_id")])
    var tags: MutableList<Tags> = mutableListOf(),
    )