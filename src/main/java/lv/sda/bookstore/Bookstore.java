package lv.sda.bookstore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Bookstore {
    private static final String FILE_NAME = "src/main/resources/books.txt";
    private List<Book> bookShelf = new ArrayList<>();

    public Bookstore() {
        try {
            Path path = Paths.get(FILE_NAME);
            List<Book> books = Files.lines(path).map(line -> {
                List<String> fields = Arrays.stream(line.split(";")).collect(toList());
                return new Book(
                        fields.get(0),
                        fields.get(1),
                        LocalDate.of(Integer.parseInt(fields.get(2)), 1, 1),
                        Integer.parseInt(fields.get(3)),
                        fields.get(4),
                        fields.get(5),
                        fields.get(6)
                );
            }).collect(toList());
            bookShelf.addAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveBooksToFile() {
        try {
            Path path = Paths.get(FILE_NAME);
            Files.write(path, bookShelf.stream().map(Book::toString).collect(toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        bookShelf.add(book);
    }

    public boolean removeBook(String isbn) {
        return bookShelf.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public void listBooks() {
        bookShelf.forEach(System.out::println);
    }

    public List<Book> getBookShelf() {
        return bookShelf;
    }
}
