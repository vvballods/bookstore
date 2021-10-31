package lv.sda.bookstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookstoreTest {

    @Test
    public void testBookWasAddedToBookshelf() {
        Bookstore bookstore = new Bookstore();

        assertEquals(0, bookstore.getBookShelf().size());

        Book book = new Book("Bada Speles", "Suzanna", LocalDate.of(1999, 4, 1), 320, "adc", "drama", "7890");
        bookstore.addBook(book);

        assertEquals(1, bookstore.getBookShelf().size());
    }

    @Test
    public void testBookWasRemovedToBookshelf() {
        Bookstore bookstore = new Bookstore();

        Book book = new Book("Bada Speles", "Suzanna", LocalDate.of(1999, 4, 1), 320, "adc", "drama", "7890");
        bookstore.addBook(book);

        assertEquals(1, bookstore.getBookShelf().size());

        bookstore.removeBook("7890");

        assertEquals(0, bookstore.getBookShelf().size());
    }
}
