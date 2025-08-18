package com.example.Tome

import com.example.Tome.ApiRest.ApiRest
import com.example.Tome.Books.BookAuthors.Authors
import com.example.Tome.Books.Books
import com.example.Tome.Books.BooksDTO
import com.example.Tome.Books.Publishers.Publishers
import com.example.Tome.BooksService.BooksService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.context.bean.override.mockito.MockitoBean

@WebMvcTest(ApiRest::class)
@AutoConfigureMockMvc(addFilters = false)
class ApiRestTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {
    @MockitoBean
    private lateinit var service: BooksService

    @Test
    fun `GET all books - returns OK`() {
        val book = BooksDTO(1L, "Clean Code", Publishers(1,"Ivrea"), mutableListOf(Authors(1,"Robert Martin")))
        `when`(service.getAll()).thenReturn(listOf(book))

        mockMvc.perform(get("/api/books"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].book_id").value(1))
            .andExpect(jsonPath("$[0].title").value("Clean Code"))
    }

    @Test
    fun `GET all books - empty list returns BAD_REQUEST`() {
        `when`(service.getAll()).thenReturn(emptyList())

        mockMvc.perform(get("/api/books"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `GET book by id - returns OK`() {
        val book = BooksDTO(1L, "Clean Code", Publishers(1,"Ivrea"), mutableListOf(Authors(1,"Robert Martin")))
        `when`(service.findBy(1L)).thenReturn(book)

        mockMvc.perform(get("/api/books/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.title").value("Clean Code"))
    }

    @Test
    fun `GET book by id - not found`() {
        `when`(service.findBy(99L)).thenReturn(null)

        mockMvc.perform(get("/api/books/99"))
            .andExpect(status().isNotFound)
    }
}
