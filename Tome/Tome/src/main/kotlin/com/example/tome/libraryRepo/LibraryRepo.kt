package com.example.tome.libraryRepo

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LibraryRepo : JpaRepository<Book, UUID> {
    fun findByTitle(title: String): Book?

    fun findByAuthors(author: List<Author>): List<Book>?

    fun findByIsbn(isbn: String): Book?
}
