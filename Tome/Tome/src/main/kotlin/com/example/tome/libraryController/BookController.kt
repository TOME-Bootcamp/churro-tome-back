package com.example.tome.libraryController

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfoDTO.BookDTO
import com.example.tome.libraryService.BooksService
import com.example.tome.toDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("/books")
class BookController(
    private val service: BooksService,
) {
    @GetMapping
    fun getBooks(): List<BookDTO> = service.getAllBooks()?.map(::toDTO) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @GetMapping
    fun getBookByTittle(
        @RequestParam title: String,
    ): BookDTO =
        toDTO(
            service.findByTitle(title) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND),
        )

    @GetMapping
    fun getBooksByAuthor(
        @RequestParam author: List<Author>,
    ): List<BookDTO> =
        service.findByAuthors(author)?.map(::toDTO)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @GetMapping
    fun getBookByIsbn(
        @RequestParam isbn: String,
    ): BookDTO? = toDTO(service.findByIsbn(isbn))

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(
        @RequestBody book: Book,
    ): BookDTO = toDTO(service.saveBook(book))

    @PostMapping("{id}")
    fun updateBook(
        @PathVariable id: UUID,
        @RequestParam book: Book,
    ): BookDTO? = toDTO(service.updateBook(book))

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(
        @PathVariable id: UUID,
    ) = service.deleteBook(id)
}
