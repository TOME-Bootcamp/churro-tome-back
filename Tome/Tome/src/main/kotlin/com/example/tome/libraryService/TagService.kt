package com.example.tome.libraryService

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.tags.Tags
import com.example.tome.libraryRepo.TagRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TagService(
    private val tagRepo: TagRepo,
) {
    fun findByBook(book: Book): List<Tags> =
        tagRepo.findByBook(book)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
