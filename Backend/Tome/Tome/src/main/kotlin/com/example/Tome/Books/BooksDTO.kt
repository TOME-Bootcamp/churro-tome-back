package com.example.Tome.Books

import com.example.Tome.Books.BookAuthors.Authors
import com.example.Tome.Books.BooksTags.Tags
import com.example.Tome.Books.Publishers.Publishers

data class BooksDTO(
    val book_id: Long?,
    val title: String,
    val isbn: String,
    val releaseDate: String,
    var pages: String,
    var url: String,
    var synopsis: String,
    var language: String,
    var publisher: Publishers?,
    var authors: MutableList<Authors>,
    var tags: MutableList<Tags>
)