package com.example.tome.bookInfoDTO

import com.example.tome.bookInfo.author.Author

data class ConditionBookDTO(
    val id: Long?,
    val title: String,
    val authors: List<Author>? = emptyList(),
    val isbn: String,
)
