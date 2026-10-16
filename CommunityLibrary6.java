```java
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Book {
    private int id;
    private String name;
    private String author;
    private boolean available;

    Book(int id, String name, String author, boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public String toString() {
        return id + " - " + name + " - " + author
                + " - " + (available ? "Available" : "Issued");
    }
}

public class CommunityLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Book> books = new ArrayList<>();
        Map<Integer, Book> bookMap = new HashMap<>();
        Set<String> authors = new HashSet<>();
        Set<String> sortedTitles = new TreeSet<>();

        books.add(new Book(101, "Java Programming", "James Gosling", true));
        books.add(new Book(102, "Python Basics", "Guido van Rossum", true));
        books.add(new Book(103, "C Programming", "Dennis Ritchie", false));
        books.add(new Book(104, "Data Structures", "Mark Allen", true));
        books.add(new Book(105, "Java Fundamentals", "James Gosling", true));

        books.forEach(book -> {
            bookMap.put(book.getId(), book);
            authors.add(book.getAuthor());
            sortedTitles.add(book.getName());
        });

        System.out.println("--- Community Library ---");
        System.out.println("1. Display All Books");
        System.out.println("2. Search Book by ID");
        System.out.println("3. Display Available Books");
        System.out.println("4. Display Authors");
        System.out.println("5. Search Books by Keyword");
        System.out.println("6. Generate Library Report");
        System.out.println("7. Exit");

        int choice;

        do {
            System.out.print("\nEnter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        books.forEach(System.out::println);
                        break;

                    case 2:
                        System.out.print("Enter book ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        Optional.ofNullable(bookMap.get(id))
                                .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Book not found.")
                                );
                        break;

                    case 3:
                        books.stream()
                                .filter(Book::isAvailable)
                                .forEach(System.out::println);
                        break;

                    case 4:
                        authors.stream()
                                .sorted()
                                .forEach(System.out::println);
                        break;

                    case 5:
                        System.out.print("Enter keyword: ");
                        String keyword = sc.nextLine().trim().toLowerCase();

                        List<Book> results = books.stream()
                                .filter(b -> b.getName()
                                        .toLowerCase().contains(keyword))
                                .collect(Collectors.toList());

                        results.forEach(System.out::println);
                        System.out.println("Books found: " + results.size());
                        break;

                    case 6:
                        long totalBooks = books.stream().count();

                        long availableBooks = books.stream()
                                .filter(Book::isAvailable)
                                .count();

                        Map<String, Long> authorCounts = books.stream()
                                .collect(Collectors.groupingBy(
                                        Book::getAuthor,
                                        TreeMap::new,
                                        Collectors.counting()
                                ));

                        String titleReport = sortedTitles.stream()
                                .collect(Collectors.joining(", "));

                        System.out.println("Total books: " + totalBooks);
                        System.out.println("Available books: " + availableBooks);
                        System.out.println("Issued books: "
                                + (totalBooks - availableBooks));
                        System.out.println("Books by author: " + authorCounts);
                        System.out.println("Book titles: " + titleReport);
                        break;

                    case 7:
                        System.out.println("Thank you for visiting!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }

        } while (choice != 7);

        sc.close();
    }
}
