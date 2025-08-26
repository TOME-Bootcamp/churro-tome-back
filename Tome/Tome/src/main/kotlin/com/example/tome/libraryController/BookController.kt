package com.example.tome.libraryController

import com.example.tome.allBook
import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfoDTO.BookDTO
import com.example.tome.bookInfoDTO.ConditionBookDTO
import com.example.tome.bookInfoDTO.allBookDTO
import com.example.tome.conditionBook
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
@RequestMapping("/Books")
class BookController(
    private val service: BooksService,
) {
    @GetMapping("/getBooks")
    fun getBooks(): List<allBookDTO> =
        service.getAllBooks()?.map(::allBook) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @GetMapping("/getById")
    fun getBookById(
        @RequestParam id: Long,
    ): allBookDTO =
        allBook(
            service.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND),
        )

    @GetMapping("/getByTittle")
    fun getBookByTittle(
        @RequestParam title: String,
    ): BookDTO =
        toDTO(
            service.findByTitle(title) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND),
        )

    @GetMapping("/getByWord")
    fun getBookByWord(@RequestParam word: String): List<ConditionBookDTO> =
        service.getBooksByWord(word)?.map(::conditionBook) ?: service.findByIsbn(word)?.map(::conditionBook)
        ?: service.findByAuthors(word)?.map(::conditionBook) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(
        @RequestBody book: Book,
    ): BookDTO = toDTO(service.saveBook(book)?: throw ResponseStatusException(HttpStatus.NOT_FOUND))

    @PostMapping("{id}")
    fun updateBook(
        @PathVariable id: UUID,
        @RequestParam book: Book,
    ): BookDTO? = toDTO(service.updateBook(book)?: throw ResponseStatusException(HttpStatus.NOT_FOUND))

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(
        @PathVariable id: Long,
    ) = service.deleteBook(id)
}
