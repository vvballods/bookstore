package lv.sda.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private List<Book> bookShelf = new ArrayList<>();

    public void addBook(Book book){
        bookShelf.add(book);
    }
    public void listBook(){
        bookShelf.forEach(System.out::println);
    }

}
