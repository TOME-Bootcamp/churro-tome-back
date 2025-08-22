package com.example.tome

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfo.tags.Tags
import com.example.tome.bookInfoDTO.AuthorDTO
import com.example.tome.bookInfoDTO.BookDTO
import com.example.tome.bookInfoDTO.TagsDTO

fun toDTO(book: Book?): BookDTO =
    BookDTO(
        book?.title,
        book?.authors,
        book?.publisher,
        book?.tags,
    )

fun toAuthorDTO(author: Author?): AuthorDTO =
    AuthorDTO(
        author?.name,
        author?.creator,
    )

fun toTagsDTO(tags: Tags?): TagsDTO =
    TagsDTO(
        tags?.name,
        tags?.tags,
    )
