package com.example.tome

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfoDTO.BookDTO
import com.example.tome.bookInfoDTO.ConditionBookDTO
import com.example.tome.bookInfoDTO.allBookDTO

fun toDTO(book: Book): BookDTO =
    BookDTO(
        book.title,
        book.authors,
        book.publisher,
        book.tags,
    )

fun allBook(book: Book): allBookDTO =
    allBookDTO(book.id, book.title,
        book.isbn, book.url,
        book.pages, book.releaseDate,
        book.synopsis, book.language,
        book.publisher, book.authors,
        book.tags)

fun conditionBook(book: Book): ConditionBookDTO =
    ConditionBookDTO(
        book.id,
        book.title,
        book.authors,
        book.isbn,
    )
