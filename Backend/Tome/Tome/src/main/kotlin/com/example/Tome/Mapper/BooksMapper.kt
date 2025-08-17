package com.example.Tome.Mapper

import com.example.Tome.Books.Books
import com.example.Tome.Books.BooksDTO

fun toDTO(books: Books): BooksDTO {
    return BooksDTO(
        book_id = books.book_id,
        title = books.title,
        isbn = books.isbn,
        releaseDate = books.releaseDate,
        pages = books.pages,
        url = books.url,
        synopsis = books.synopsis,
        language = books.language,
        publisher = books.publisher,
        authors = books.authors,
        tags = books.tags,
    )
}

fun toBook(booksDTO: BooksDTO): Books {
    return Books(
        book_id = booksDTO.book_id,
        title = booksDTO.title,
        isbn = booksDTO.isbn,
        releaseDate = booksDTO . releaseDate,
        pages = booksDTO.pages,
        url = booksDTO . url,
        synopsis = booksDTO.synopsis,
        language = booksDTO . language,
        publisher = booksDTO.publisher,
        authors = booksDTO.authors,
        tags = booksDTO.tags,
    )
}