package com.example.tome.libraryRepo

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.tags.Tags
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TagRepo : JpaRepository<Tags, UUID> {
    fun findByBook(book: Book): List<Tags>?
    fun findByName(name: String): Tags?
}
