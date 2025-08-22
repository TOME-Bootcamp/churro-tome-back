package com.example.tome.libraryController

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfoDTO.AuthorDTO
import com.example.tome.libraryService.AuthorService
import com.example.tome.toAuthorDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tags")
class AuthorController(
    private val author: AuthorService,
) {
    @GetMapping
    fun findByBooks(book: Book): List<AuthorDTO> = author.getBooks(book).map(::toAuthorDTO)
}
