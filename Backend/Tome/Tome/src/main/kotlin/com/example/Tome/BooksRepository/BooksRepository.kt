package com.example.Tome.BooksRepository

import com.example.Tome.Books.Books
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface BooksRepository : JpaRepository<Books, Long>{
    
    fun save(book: Books): Books
    fun findByname(name : String): Books
    fun update(book: Books): Books
    fun delete(id: Long): Books
}