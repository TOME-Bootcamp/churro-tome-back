package com.example.Tome

import com.example.Tome.Books.BookAuthors.Authors
import com.example.Tome.Books.Books
import com.example.Tome.Books.BooksTags.Tags
import com.example.Tome.Books.Publishers.Publishers
import com.example.Tome.BooksRepository.BooksRepository
import com.example.Tome.Seeder.BookSeeder
import org.hamcrest.CoreMatchers.any
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest
import kotlin.concurrent.timer

class TomeApplicationTests {

	private lateinit var booksRepository: BooksRepository
	private lateinit var bookSeeder: BookSeeder

	@BeforeEach
	fun setup(){
		booksRepository = mock(BooksRepository::class.java)
		bookSeeder = BookSeeder(booksRepository)
	}
	@Test
	fun `should seed when book does not exist`() {
		`when`(booksRepository.existsById(1)).thenReturn(false)

		bookSeeder.run()

		verify(booksRepository, times(1)).existsById(1)
	}

	@Test
	fun `should not seed when book already exists`() {
		`when`(booksRepository.existsById(1)).thenReturn(true)

		bookSeeder.run()
		val books =
			Books(1,"The Fellowship of the Ring", "9780547928210", "1954-07-29", "407", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1651340688i/727798.jpg",
				"The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
						"One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
						"In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit. In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.",
				"ENGLISH", Publishers(1,"William Morrow"),
				mutableListOf(Authors(1,"J.R.R Tolkien")), mutableListOf(Tags(1,"Fantasy"), Tags(2,"Classics")))

		verify(booksRepository, never()).save(books)
	}
}
