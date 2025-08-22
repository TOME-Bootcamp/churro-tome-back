package com.example.tome.bookInfoDTO

import com.example.tome.bookInfo.Book

class TagsDTO(
    private val name: String?,
    private val tags: MutableList<Book>? = mutableListOf(),
)
