package com.example.tome.seeder

import com.example.tome.bookInfo.Book
import com.example.tome.bookInfo.author.Author
import com.example.tome.bookInfo.author.AuthorRepo
import com.example.tome.bookInfo.language.Language
import com.example.tome.bookInfo.publisher.Publisher
import com.example.tome.bookInfo.publisher.PublisherRepo
import com.example.tome.bookInfo.tags.TagRepo
import com.example.tome.bookInfo.tags.Tags
import com.example.tome.libraryRepo.LibraryRepo
import org.springframework.boot.CommandLineRunner
import org.springframework.data.jpa.repository.Query
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Component
class BookSeeder(
    private val booksRepository: LibraryRepo,
    private val tagsRepo: TagRepo,
    private val authorRepo: AuthorRepo,
    private val publisherRepo: PublisherRepo,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        seedAuthor()
        seedPublisher()
        seedTags()
        seedBooks()
    }

    private fun seedPublisher() {
        val publisher =
            listOf<Publisher>(
                Publisher(
                    null,
                    "William Morrow",
                ), Publisher(null, "Atria Books"),
                Publisher(null,"Dragonsteel Entertainment"),
                Publisher(null,"Ace")
            )
        publisherRepo.saveAll(publisher)
    }

    private fun seedAuthor() {
        val author =
            listOf<Author>(
                Author(
                    null,
                    "J.R.R","Tolkien"
                ),Author(null, "Fredrik", "Backman"),
                Author(null, "Brandon","Sanderson"),
                Author(null, "Frank", "Herbert")
            )
        authorRepo.saveAll(author)
    }

    private fun seedTags() {
        val tags =
            listOf<Tags>(
                Tags(null, "Fantasy",),
                Tags(null, "Fiction",),
                Tags(null, "Science Fiction",),
                Tags(null, "Contemporary",),
            )
        tagsRepo.saveAll(tags)
    }

    private fun seedBooks() {
        val author2 : Author = authorRepo.findByName("J.R.R")!!
        val publisher2 : Publisher = publisherRepo.findByName("William Morrow")!!
        val tag2 : Tags = tagsRepo.findByName("Fantasy")!!
        val author3 : Author = authorRepo.findByName("Fredrik")!!
        val publisher3 : Publisher = publisherRepo.findByName("Atria Books")!!
        val tag3 : Tags = tagsRepo.findByName("Fiction")!!
        val author4 : Author = authorRepo.findByName("Brandon")!!
        val publisher4 : Publisher = publisherRepo.findByName("Dragonsteel Entertainment")!!
        val authorHerbert: Author = authorRepo.findByName("Frank")!!
        val publisherAce: Publisher = publisherRepo.findByName("Ace")!!
        val tagSciFi: Tags = tagsRepo.findByName("Science Fiction")!!

        val books =
            listOf<Book>(
                Book(
                    null,
                    "The Fellowship of the Ring",
                    "9780547928210",
                    "1954-07-29",
                    "407",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1651340688i/727798.jpg",
                    "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
                        "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
                        "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit. In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.",
                    Language.ENGLISH,
                    listOf(author2),
                    publisher2,
                    listOf(tag2),
                ),Book(null, "The Two Towers", "9780261102361", "1954-11-11", "448", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1629308732i/727800.jpg", "Begin your journey into Middle-earth.\n" +
                        "The inspiration for the upcoming original series on Prime Video, The Lord of the Rings: The Rings of Power.\n" +
                        "The Two Towers is the second part of J.R.R. Tolkien’s epic adventure The Lord of the Rings.\n" +
                        "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them.\n" +
                        "Frodo and his Companions of the Ring have been beset by danger during their quest to prevent the Ruling Ring from falling into the hands of the Dark Lord by destroying it in the Cracks of Doom. They have lost the wizard, Gandalf, in a battle in the Mines of Moria. And Boromir, seduced by the power of the Ring, tried to seize it by force. While Frodo and Sam made their escape, the rest of the company was attacked by Orcs. Now they continue the journey alone down the great River Anduin—alone, that is, save for the mysterious creeping figure that follows wherever they go.",
                    Language.ENGLISH, listOf(author2), publisher2, listOf(tag2),),
                Book(null, "The Return of the King", "9780261102378", "1955-10-20", "432", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1634055544i/727810.jpg",
                    "The first volume in J.R.R. Tolkien's epic adventure THE LORD OF THE RINGS\n" +
                            "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\n" +
                            "In ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell into the hands of Bilbo Baggins, as told in The Hobbit. In a sleepy village in the Shire, young Frodo Baggins finds himself faced with an immense task, as his elderly cousin Bilbo entrusts the Ring to his care. Frodo must leave his home and make a perilous journey across Middle-earth to the Cracks of Doom, there to destroy the Ring and foil the Dark Lord in his evil purpose.",
                    Language.ENGLISH,listOf(author2), publisher2, listOf(tag2)),
                Book(null, "My Friends", "9781982112820","2025-05-06", "436", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1734625930i/217163697.jpg","\"The world is full of miracles, but none greater than how far a young person can be carried by someone else's belief in them.\"\n" +
                        "\n" +
                        "Most people don’t even notice them—three tiny figures sitting at the end of a long pier in the corner of one of the most famous paintings in the world. Most people think it’s just a depiction of a wide expanse of sea. But Louisa, soon to be eighteen years old and an aspiring artist herself, knows otherwise. She is determined to find out the story behind these three enigmatic figures.\n" +
                        "\n" +
                        "More than two decades before, in a distant seaside town, a group of teenagers find refuge from their bruising home lives by spending long summer days on an abandoned pier telling silly jokes, sharing secrets, and committing small acts of rebellion. These lost souls find in each other a reason to get up every morning, a reason to dream, a reason to love.\n" +
                        "\n" +
                        "Out of that summer emerges a transcendent work of art, a painting that, after a chance encounter in an alleyway, will unexpectedly be placed into Louisa’s care. She embarks on a surprise-filled cross-country journey to discover how the painting came to be and to decide what to do with it. The closer she gets to the painting’s birthplace, the more anxious she becomes about what she'll find. Louisa's complicated life is proof that happy endings are sometimes possible, but they don't always take the form we expect them to.\n" +
                        "\n" +
                        "Fredrik Backman's signature charm, humor, and attention to the poignant details of everyday life are on full display in this funny, moving novel. His most heartfelt and personal tale yet, My Friends is a stunning testament to the transformative, timeless power of art and friendship.",
                    Language.ENGLISH, listOf(author3), publisher3, listOf(tag3)),
                Book(
                    null,
                    "Beartown",
                    "9781501160769",
                    "2017-04-25",
                    "418",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1525349525i/31443394.jpg",
                    "People say Beartown is finished. A tiny community nestled deep in the forest...",
                    Language.ENGLISH,
                    listOf(author3),
                    publisher3,
                    listOf(tag3)
                ),
                Book(
                    null,
                    "And Every Morning the Way Home Gets Longer and Longer",
                    "9781501160578",
                    "2015-08-24",
                    "97",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1472074835i/31373633.jpg",
                    "From the New York Times bestselling author of A Man Called Ove...",
                    Language.ENGLISH,
                    listOf(author3),
                    publisher3,
                    listOf(tag3)
                ),
                Book(
                    null,
                    "Tress of the Emerald Sea",
                    "",
                    "2023-01-10",
                    "443",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1672574587i/60531406.jpg",
                    "The only life Tress has known on her island home in an emerald-green ocean...",
                    Language.ENGLISH,
                    listOf(author4),
                    publisher4,
                    listOf(tag2)
                ),
                Book(
                    null,
                    "Yumi and the Nightmare Painter",
                    "9781938570377",
                    "2023-07-01",
                    "480",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1689135481i/60531416.jpg",
                    "Yumi comes from a land of gardens, meditation, and spirits...",
                    Language.ENGLISH,
                    listOf(author4),
                    publisher4,
                    listOf(tag2)
                ),
                Book(
                    null,
                    "The Sunlit Man",
                    "9781938570391",
                    "2023-10-01",
                    "447",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1696146860i/60531420.jpg",
                    "Running. Putting distance between himself and the relentless Night Brigade...",
                    Language.ENGLISH,
                    listOf(author4),
                    publisher4,
                    listOf(tag2)
                ),
                Book(
                    null,
                    "Dune",
                    "9780593099322",
                    "1965-06-01",
                    "658",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1555447414i/44767458.jpg",
                    "Set on the desert planet Arrakis, Dune is the story of the boy Paul Atreides...",
                    Language.ENGLISH,
                    listOf(authorHerbert),
                    publisherAce,
                    listOf(tagSciFi)
                ),
                Book(
                    null,
                    "Dune Messiah",
                    "9780593098233",
                    "1969-07-01",
                    "336",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1577043824i/44492285.jpg",
                    "Dune Messiah continues the story of Paul Atreides...",
                    Language.ENGLISH,
                    listOf(authorHerbert),
                    publisherAce,
                    listOf(tagSciFi)
                ),
                Book(
                    null,
                    "Children of Dune",
                    "9780593098240",
                    "1976-04-01",
                    "609",
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1564783201i/44492286.jpg",
                    "The Children of Dune are twin siblings Leto and Ghanima Atreides...",
                    Language.ENGLISH,
                    listOf(authorHerbert),
                    publisher4,
                    listOf(tagSciFi)
                )
            )
       booksRepository.saveAll(books)
    }
}
