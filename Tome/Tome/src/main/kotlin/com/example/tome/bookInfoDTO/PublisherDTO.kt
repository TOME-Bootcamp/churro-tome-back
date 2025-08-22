package com.example.tome.bookInfoDTO

class PublisherDTO(
    private val name: String,
    private val publisher: MutableList<BookDTO> = mutableListOf(),
)
