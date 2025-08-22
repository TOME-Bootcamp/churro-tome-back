package com.example.tome.seeder

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfo.language.Language
import com.example.tome.bookInfo.publisher.Publisher
import com.example.tome.bookInfo.tags.Tags
import com.example.tome.libraryRepo.AuthorRepo
import com.example.tome.libraryRepo.LibraryRepo
import com.example.tome.libraryRepo.TagRepo
import org.springframework.boot.CommandLineRunner
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController

class BookSeeder(private val booksRepository: LibraryRepo, private val tagsRepo : TagRepo, private val authorRepo: AuthorRepo): CommandLineRunner {
    override fun run(vararg args: String?) {
        seedAuthor()
        seedBooks()
    }

    private fun seedAuthor(){
        val author = listOf<Author>(
            Author(UUID.randomUUID(),"J.R.R, Tolkien",mutableListOf<Book>(booksRepository.findByTitle("The Fellowship of the Ring")!!))
        )
        author.forEach { author ->
            if(authorRepo.existsById(author.id?: throw ResponseStatusException(HttpStatus.NOT_FOUND))){
                authorRepo.save(author)
            }
        }
    }
    private fun seedTags(){
        val tags = listOf<Tags>(
            Tags(UUID.randomUUID(),"Fantasy",mutableListOf<Book>(booksRepository.findByTitle("The Fellowship of the Ring")!!))
        )
        tags.forEach { tags ->
            if(tagsRepo.existsById(tags.id?: throw ResponseStatusException(HttpStatus.NOT_FOUND))){
                tagsRepo.save(tags)
            }
        }
    }
    private fun seedBooks() {
        val books = listOf<Book>(
            Book(UUID.randomUUID(),"The Fellowship of the Ring", "9780547928210", "1954-07-29", "407", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1651340688i/727798.jpg",
                "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
                        "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
                        "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit. In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.",
                Language.ENGLISH,mutableListOf<Author>(authorRepo.findByName("J.R.R, Tolkien")!!),Publisher(),mutableListOf<Tags>(tagsRepo.findByName("Fantasy")!!)))
        books.forEach { book ->
            if(booksRepository.existsById(book.id?: throw ResponseStatusException(HttpStatus.NOT_FOUND))){
                booksRepository.save(book)
            }
        }
    }
}
