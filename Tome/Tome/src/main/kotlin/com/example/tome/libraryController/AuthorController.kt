package com.example.tome.libraryController

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfoDTO.AuthorDTO
import com.example.tome.bookInfoDTO.BookDTO
import com.example.tome.libraryService.AuthorService
import com.example.tome.toAuthorDTO
import com.example.tome.toDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/Author")
class AuthorController(
    private val author: AuthorService,
) {
    @GetMapping
    fun findBooks(@RequestParam name: String): List<BookDTO> = (author.getBooks(name)
        ?:throw ResponseStatusException(HttpStatus.NOT_FOUND)).map(::toDTO)
    @GetMapping("/all")
    fun findByName(@RequestParam name: String): AuthorDTO = toAuthorDTO((author.getAuthor(name)
        ?:throw ResponseStatusException(HttpStatus.NOT_FOUND)))
}
