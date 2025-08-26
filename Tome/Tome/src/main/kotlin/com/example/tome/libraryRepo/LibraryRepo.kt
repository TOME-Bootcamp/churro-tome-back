package com.example.tome.libraryRepo

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LibraryRepo : JpaRepository<Book, Long> {
    fun findByTitle(title: String): Book?

    fun findByAuthors_NameContainsIgnoreCase(author: String): List<Book>?

    fun findByIsbnContainsIgnoreCase(isbn: String): List<Book>?
    fun findByTitleContainingIgnoreCase(word: String): List<Book>?

}
