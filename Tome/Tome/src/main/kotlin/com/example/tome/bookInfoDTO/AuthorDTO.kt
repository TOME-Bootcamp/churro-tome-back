package com.example.tome.bookInfoDTO

import com.example.tome.bookInfo.Book

class AuthorDTO(
    private val name: String?,
    private val creator: MutableList<Book>? = mutableListOf(),
)
