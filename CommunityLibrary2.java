```java
import java.util.Scanner;

class CommunityLibrary2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int availableBooks = 30;
        int choice;

        do {
            System.out.println("\n--- Community Library ---");
            System.out.println("1. View Available Books");
            System.out.println("2. Issue Books");
            System.out.println("3. Return Books");
            System.out.println("4. Search for a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available books: " + availableBooks);
                    break;

                case 2:
                    System.out.print("Enter number of books to issue: ");
                    int issue = sc.nextInt();

                    if (issue > 0) {
                        if (issue <= availableBooks) {
                            availableBooks -= issue;
                            System.out.println("Books issued successfully!");
                        } else {
                            System.out.println("Not enough books available.");
                        }
                    } else {
                        System.out.println("Invalid number of books.");
                    }
                    break;

                case 3:
                    System.out.print("Enter number of books to return: ");
                    int returned = sc.nextInt();

                    if (returned > 0) {
                        availableBooks += returned;
                        System.out.println("Books returned successfully!");
                    } else {
                        System.out.println("Invalid number of books.");
                    }
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter book name to search: ");
                    String bookName = sc.nextLine();

                    String[] books = {
                        "Java", "Python", "C Programming",
                        "Data Structures", "Computer Networks"
                    };

                    boolean found = false;

                    for (String book : books) {
                        if (book.equalsIgnoreCase(bookName)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Book found in the library.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
```
