package com.example.tome.libraryService

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.libraryRepo.LibraryRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class BooksService(
    private val libraryRepo: LibraryRepo,
) {
    fun findByTitle(title: String): Book? = libraryRepo.findByTitle(title) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun findByAuthors(author: List<Author>): List<Book>? =
        libraryRepo.findByAuthors(author) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun findByIsbn(isbn: String): Book? = libraryRepo.findByIsbn(isbn)

    fun getAllBooks(): List<Book>? = libraryRepo.findAll()

    fun deleteBook(id: UUID): Unit? =
        libraryRepo.delete(
            libraryRepo
                .findById(id)
                .orElseThrow { ResponseStatusException(HttpStatus.BAD_REQUEST, "Book Not Found") },
        )

    fun updateBook(book: Book): Book? = libraryRepo.save<Book>(book)

    fun saveBook(book: Book): Book? = libraryRepo.save(book)
}
