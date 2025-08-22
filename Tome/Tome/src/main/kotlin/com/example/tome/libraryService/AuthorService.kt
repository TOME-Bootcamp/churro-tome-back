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
    fun getBooks(name: String): List<Book>? =
        authorRepo.findBooks(name)
    fun getAuthor(name: String): Author? = authorRepo.findByName(name)
}
