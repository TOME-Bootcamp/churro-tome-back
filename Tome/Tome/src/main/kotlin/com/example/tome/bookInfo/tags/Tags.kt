package com.example.tome.bookInfo.tags

import com.example.tome.bookInfo.Book
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.util.UUID

@Entity
class Tags(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String,
)
