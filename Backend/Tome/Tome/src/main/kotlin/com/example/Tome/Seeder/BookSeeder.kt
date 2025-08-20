package com.example.Tome.Seeder

import com.example.Tome.Books.BookAuthors.Authors
import com.example.Tome.Books.Books
import com.example.Tome.Books.BooksTags.Tags
import com.example.Tome.Books.Publishers.Publishers
import com.example.Tome.BooksRepository.BooksRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.core.metrics.StartupStep
import org.springframework.stereotype.Controller

@Controller
class BookSeeder(private val booksRepository: BooksRepository): CommandLineRunner {
    override fun run(vararg args: String?) {
        seedBooks()
    }

    private fun seedBooks() {
        val books = listOf<Books>(
            Books(1,"The Fellowship of the Ring", "9780547928210", "1954-07-29", "407", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1651340688i/727798.jpg",
                "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
                    "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
                    "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit. In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.",
                "ENGLISH", Publishers(1,"William Morrow"),
               mutableListOf(Authors(1,"J.R.R Tolkien")), mutableListOf(Tags(1,"Fantasy"),
                    StartupStep.Tags(2, "Classics")
                ))
        )

        books.forEach { book ->
            val exists = booksRepository.existsById(book.book_id)
            if (!exists) {
                booksRepository.save(book)
            }
        }
    }

}