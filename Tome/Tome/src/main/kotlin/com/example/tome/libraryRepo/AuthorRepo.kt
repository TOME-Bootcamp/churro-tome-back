package com.example.tome.libraryRepo

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AuthorRepo : JpaRepository<Author, UUID> {
    @Query(""" SELECT creator FROM Author where name = :authorName""")
    fun findBooks(authorName: String): List<Book>?
    fun findByName(name: String): Author?
}
