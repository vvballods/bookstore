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
            System.out.println(" To quit press: q");
            String input = scanner.next();
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

                    bookstore.addBook(new Book("Bada Speles", "Suzanna", LocalDate.of(1999, 04, 1), 320, "adc", "drama", "7890"));
                    bookstore.listBook();
                    break;
                case "3":
                    System.out.println("Removing book");
                    break;
                default:
                    System.out.println("Wrong input, please try again");


            }

        }

    }

    public static int inputNumber() {
        while (true) {
            System.out.println("Ievadiet skaitli: ");
            return handleUserNumberInput(scanner.nextLine());
        }
    }

    public static int handleUserNumberInput(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new UserInputValidationException("pages", e);
        }
    }
}

class UserInputValidationException extends RuntimeException{
    public UserInputValidationException(String field, Exception e) {
        super("Validation error in user CLI input field: " + field, e);
    }
}
