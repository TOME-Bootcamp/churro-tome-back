package com.example.tome.bookInfo.tags

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TagRepo : JpaRepository<Tags, Long>{
    fun findByName(name: String): Tags?
}
