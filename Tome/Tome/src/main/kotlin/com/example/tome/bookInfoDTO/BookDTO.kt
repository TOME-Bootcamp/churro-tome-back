package com.example.tome.bookInfoDTO

import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfo.publisher.Publisher
import com.example.tome.bookInfo.tags.Tags

class BookDTO(
    private val title: String? = null,
    private val authors: List<Author>? = ArrayList(),
    private val publishers: Publisher? = null,
    private val tags: List<Tags>? = ArrayList(),
)
