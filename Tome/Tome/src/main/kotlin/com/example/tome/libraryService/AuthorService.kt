package com.example.tome.libraryService

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.libraryRepo.AuthorRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AuthorService(
    private val authorRepo: AuthorRepo,
) {
    fun getBooks(book: Book): List<Author> =
        authorRepo.findByBook(book)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
