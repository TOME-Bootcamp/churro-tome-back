package com.example.Tome.Books.BookAuthors

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

import jakarta.persistence.Table


@Entity
@Table(name = "authors")
class Authors (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var author_id: Long = 0,

    @Column
    var name: String = ""

)