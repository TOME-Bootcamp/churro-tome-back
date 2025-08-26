package com.example.tome.bookInfo.author

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AuthorRepo : JpaRepository<Author, Long> {

    fun findByName(firstName: String): Author?
    fun findBySurname(surname: String): Author?
}
