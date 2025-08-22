package com.example.tome.libraryController

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfoDTO.TagsDTO
import com.example.tome.libraryService.TagService
import com.example.tome.toTagsDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tags")
class TagController(
    private val tagService: TagService,
) {
    @GetMapping
    fun findByBook(book: Book): List<TagsDTO> = tagService.findByBook(book).map(::toTagsDTO)
}
