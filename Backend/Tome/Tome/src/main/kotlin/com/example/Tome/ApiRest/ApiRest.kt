package com.example.Tome.ApiRest

import com.example.Tome.Books.Books
import com.example.Tome.Books.BooksDTO
import com.example.Tome.BooksService.BooksService
import jakarta.persistence.PostUpdate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/Books")
class ApiRest(private val service: BooksService) {

    @GetMapping
    fun getBooks(): ResponseEntity<List<BooksDTO>>{
        val listOfBooks = service.getAll()
        if(listOfBooks == null || listOfBooks.isEmpty()){
            return badRequest()
        }
        return ResponseEntity.ok(listOfBooks);
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): ResponseEntity<BooksDTO>{
        val books = service.findBy(id)
        if(books == null){
            return entityNotFound()
        }
        return ResponseEntity.ok(books);
    }

    @PostMapping
    fun updateBook(@RequestBody books: Books): ResponseEntity<BooksDTO>{
        val booksDTO = service.update(books)
        if(booksDTO == null){
            return entityNotFound()
        }
        return ResponseEntity.ok(booksDTO);
    }

    @DeleteMapping("/delete/{id}")
    fun deleteBook(@RequestBody id: Long): ResponseEntity<BooksDTO>{
        val deletedBook = service.delete(id)
        if(deletedBook == null){
            return entityNotFound()
        }
        return ResponseEntity.ok(deletedBook)
    }

    @PutMapping
    fun putBook(@RequestBody book: Books): ResponseEntity<BooksDTO>{
        return ResponseEntity.ok(service.save(book));
    }

    @ExceptionHandler
    fun badRequest(): ResponseEntity<List<BooksDTO>> {
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler
    fun entityNotFound(): ResponseEntity<BooksDTO> {
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}