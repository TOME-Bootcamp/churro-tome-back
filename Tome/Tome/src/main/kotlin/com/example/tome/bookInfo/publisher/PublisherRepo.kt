package com.example.tome.bookInfo.publisher

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PublisherRepo : JpaRepository<Publisher, Long> {

    fun findByName(name: String): Publisher?
}
