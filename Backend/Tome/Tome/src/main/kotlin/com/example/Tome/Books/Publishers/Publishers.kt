package com.example.Tome.Books.Publishers

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tags")
class Publishers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var publishsr_id: Long? = null

    @Column
    var name: String? = null
}