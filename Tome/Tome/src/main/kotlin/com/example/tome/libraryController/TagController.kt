package com.example.tome.libraryController

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.tags.Tags
import com.example.tome.bookInfoDTO.BookDTO
import com.example.tome.bookInfoDTO.TagsDTO
import com.example.tome.libraryService.TagService
import com.example.tome.toDTO
import com.example.tome.toTagsDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/Tags")
class TagController(
    private val tagService: TagService,
) {
    @GetMapping
    fun findBooks(bookname: String): List<BookDTO> = (tagService.findByBook(bookname)?: throw ResponseStatusException(
        HttpStatus.NOT_FOUND)).map(::toDTO)

    @GetMapping("/getByName")
    fun findByName(name: String): TagsDTO = toTagsDTO(tagService.findByName(name)?: throw ResponseStatusException(
        HttpStatus.NOT_FOUND))
}
