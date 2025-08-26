package com.example.tome.libraryRepo

import com.example.tome.bookInfo.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LibraryRepo : JpaRepository<Book, Long> {
    fun findByTitle(title: String): Book?

    fun findByAuthorsNameContainsIgnoreCase(author: String): List<Book>?

    fun findByIsbnContainsIgnoreCase(isbn: String): List<Book>?

    fun findByTitleContainingIgnoreCase(word: String): List<Book>?
}
