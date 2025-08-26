package com.example.tome.bookInfoDTO

import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfo.language.Language
import com.example.tome.bookInfo.publisher.Publisher
import com.example.tome.bookInfo.tags.Tags

data class AllBookDTO(
    val id: Long?,
    val title: String,
    val isbn: String?,
    val url: String?,
    val pages: String?,
    val releaseDate: String?,
    val synopsis: String?,
    val language: Language,
    val publisher: Publisher?,
    val authors: List<Author>?,
    val tags: List<Tags>?,
)
