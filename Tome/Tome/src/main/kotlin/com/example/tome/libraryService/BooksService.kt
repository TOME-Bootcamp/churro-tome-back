package com.example.tome.libraryService

import com.example.tome.bookInfo.Book
import com.example.tome.libraryRepo.LibraryRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class BooksService(
    private val libraryRepo: LibraryRepo,
) {
    fun findByTitle(title: String): Book? = libraryRepo.findByTitle(title) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun findById(id: Long): Book? = libraryRepo.findById(id).orElseThrow() ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun findByAuthors(author: String): List<Book>? =
        libraryRepo.findByAuthorsNameContainsIgnoreCase(author) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun findByIsbn(isbn: String): List<Book>? = libraryRepo.findByIsbnContainsIgnoreCase(isbn)

    fun getAllBooks(): List<Book>? = libraryRepo.findAll()

    fun getBooksByWord(word: String): List<Book>? = libraryRepo.findByTitleContainingIgnoreCase(word)

    fun deleteBook(id: Long): Unit? =
        libraryRepo.delete(
            libraryRepo
                .findById(id)
                .orElseThrow { ResponseStatusException(HttpStatus.BAD_REQUEST, "Book Not Found") },
        )

    fun updateBook(book: Book): Book? = libraryRepo.save<Book>(book)

    fun saveBook(book: Book): Book? = libraryRepo.save(book)
}
