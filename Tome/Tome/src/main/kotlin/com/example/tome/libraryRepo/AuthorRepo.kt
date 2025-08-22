package com.example.tome.libraryRepo

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AuthorRepo : JpaRepository<Author, UUID> {
    fun findByBook(book: Book): List<Author>?
    fun findByName(name: String): Author?
}
