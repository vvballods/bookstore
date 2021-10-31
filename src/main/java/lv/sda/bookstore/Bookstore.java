package lv.sda.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private List<Book> bookShelf = new ArrayList<>();

    public void addBook(Book book){
        bookShelf.add(book);
    }
    public void removeBook(String isbn) {
        bookShelf.removeIf(book -> book.getIsbn().equals(isbn));
    }
    public void listBook(){
        bookShelf.forEach(System.out::println);
    }

    public List<Book> getBookShelf() {
        return bookShelf;
    }
}
