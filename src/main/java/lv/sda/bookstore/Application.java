package lv.sda.bookstore;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        while (true) {
            System.out.println("Book Store Menu");
            System.out.println("1. Search Book");
            System.out.println("2. Add Book");
            System.out.println("3. Remove Book");
            System.out.println("4. List Available Books");
            System.out.println(" To quit press: q");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                System.out.println("Quiting application");
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("Searching for book");
                    break;
                case "2":
                    System.out.println("Adding book");
                    bookstore.addBook(inputBook());
                    break;
                case "3":
                    System.out.println("Removing book");
                    System.out.println("Provide Isbn of the book to remove: ");
                    String isbn = scanner.nextLine();
                    boolean removed = bookstore.removeBook(isbn);
                    if (removed) {
                        System.out.println("Book with isbn " + isbn + " was removed!");
                    } else {
                        System.out.println("Book with isbn " + isbn + " was not found!");
                    }
                    break;
                case "4":
                    System.out.println("Listing available books:");
                    bookstore.listBooks();
                    break;
                default:
                    System.out.println("Wrong input, please try again");
            }
            System.out.println();
        }
        bookstore.saveBooksToFile();
    }

    public static Book inputBook() {
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Author: ");
        String author = scanner.nextLine();
        System.out.println("Publishing year: ");
        LocalDate publishingYear = LocalDate.of(Integer.parseInt(scanner.nextLine()), 1, 1);
        System.out.println("Pages: ");
        int pages = Integer.parseInt(scanner.nextLine());
        System.out.println("Publisher: ");
        String publisher = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Isbn: ");
        String isbn = scanner.nextLine();
        return new Book(title, author, publishingYear, pages, publisher, description, isbn);
    }
}
