```java
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class CommunityLibrary {

    static ArrayList<String> books = new ArrayList<>();
    static Path file = Paths.get("books.txt");

    static void loadBooks() {
        try {
            if (Files.exists(file)) {
                books.clear();
                for (String line : Files.readAllLines(file)) {
                    if (!line.trim().isEmpty()) {
                        books.add(line.trim());
                    }
                }
            } else {
                books.add("Java Programming");
                books.add("Python Basics");
                books.add("C Programming");
                saveBooks();
            }
        } catch (IOException e) {
            System.out.println("Error loading books.");
        }
    }

    static void saveBooks() {
        try {
            Files.write(file, books);
            System.out.println("Book records saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    static void displayBooks() {
        Collections.sort(books, String.CASE_INSENSITIVE_ORDER);

        System.out.println("\nAvailable Books:");
        for (String book : books) {
            System.out.println(book);
        }
    }

    static void addBook(String bookName) {
        bookName = bookName.trim();

        if (bookName.isEmpty()) {
            System.out.println("Book name cannot be empty.");
            return;
        }

        books.add(bookName);
        saveBooks();
        System.out.println("Book added successfully.");
    }

    static void searchBook(String bookName) {
        for (String book : books) {
            if (book.equalsIgnoreCase(bookName.trim())) {
                System.out.println("Book found: " + book);
                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void removeBook(String bookName) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equalsIgnoreCase(bookName.trim())) {
                books.remove(i);
                saveBooks();
                System.out.println("Book removed successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void generateReport() {
        StringBuilder report = new StringBuilder();

        report.append("COMMUNITY LIBRARY REPORT\n");
        report.append("Total Books: ").append(books.size()).append("\n");

        for (String book : books) {
            report.append(book).append("\n");
        }

        try {
            Files.writeString(
                Paths.get("library_report.txt"),
                report.toString()
            );
            System.out.println("Report generated successfully.");
        } catch (IOException e) {
            System.out.println("Error generating report.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadBooks();

        int choice;

        do {
            System.out.println("\n--- Community Library ---");
            System.out.println("1. Display Books");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        displayBooks();
                        break;

                    case 2:
                        System.out.print("Enter book name: ");
                        addBook(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter book name to search: ");
                        searchBook(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Enter book name to remove: ");
                        removeBook(sc.nextLine());
                        break;

                    case 5:
                        generateReport();
                        break;

                    case 6:
                        System.out.println("Thank you for visiting!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }

        } while (choice != 6);

        sc.close();
    }
}

