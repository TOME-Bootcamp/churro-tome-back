package com.example.Tome.Books.BooksTags

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tags")

class Tags(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var tags_id: Long = 0,

    @Column
    var name: String = ""
)