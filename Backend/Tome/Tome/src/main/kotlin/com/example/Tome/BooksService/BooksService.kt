package com.example.Tome.BooksService

import com.example.Tome.Books.Books
import com.example.Tome.Books.BooksDTO
import com.example.Tome.BooksRepository.BooksRepository
import com.example.Tome.Mapper.toDTO
import org.springframework.stereotype.Service

@Service
class BooksService(private val booksRepository: BooksRepository) {

    fun findBy(id: Long): BooksDTO? {
        val book = booksRepository.findById(id).orElse(null) ?: return null
        return toDTO(book)
    }
    fun findByName(name: String): BooksDTO? {
        val book = booksRepository.findByname(name)
        return toDTO(book)
    }
    fun save(book: Books): BooksDTO? {
        val books = booksRepository.save(book)
        return toDTO(books)
    }
    fun update(book: Books): BooksDTO? {
        val books = booksRepository.update(book)
        return toDTO(books)
    }
    fun delete(id: Long): BooksDTO? {
        val book = booksRepository.delete(id)
        return toDTO(book)
    }
    fun getAll(): List<BooksDTO>? {
        val books = booksRepository.findAll()
        val listOfBooks = ArrayList<BooksDTO>()
        for (book in books) {
            listOfBooks.add(toDTO(book))
        }
        return listOfBooks
    }
}