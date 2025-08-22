package com.example.tome.libraryRepo

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.tags.Tags
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TagRepo : JpaRepository<Tags, UUID> {
    @Query(""" SELECT tags from Tags where name = :bookName""")
    fun findBooks(bookName: String): List<Book>?

    fun findByName(name: String): Tags?
}
