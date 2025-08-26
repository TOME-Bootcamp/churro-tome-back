package com.example.tome.bookInfoDTO

import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfo.publisher.Publisher
import com.example.tome.bookInfo.tags.Tags

data class BookDTO(
    val title: String?,
    val authors: List<Author>? = emptyList(),
    val publisher: Publisher? = null,
    val tags: List<Tags>? = emptyList(),
)
