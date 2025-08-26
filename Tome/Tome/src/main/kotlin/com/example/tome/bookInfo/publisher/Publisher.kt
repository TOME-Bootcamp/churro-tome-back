package com.example.tome.bookInfo.publisher

import com.example.tome.bookInfo.Book
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID

@Entity
class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String

)
