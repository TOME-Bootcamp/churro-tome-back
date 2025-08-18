package com.example.Tome.Mapper

import com.example.Tome.Books.Books
import com.example.Tome.Books.BooksDTO

fun toDTO(books: Books): BooksDTO {
    return BooksDTO(
        book_id = books.book_id,
        title = books.title,
        publisher = books.publisher,
        authors = books.authors,
    )
}