package com.example.tome.bookInfo.publisher

import com.example.tome.bookInfo.Book
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.util.UUID

@Entity
class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null

    val name: String? = null

    @ManyToMany(mappedBy = "publisher")
    val publisher: MutableList<Book> = mutableListOf()
}
