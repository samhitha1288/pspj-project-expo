```java
import java.util.Scanner;

class CommunityLibrary3 {

    static String[] books = {
        "Java", "Python", "C Programming", "Data Structures"
    };

    static int[][] bookCopies = {
        {10, 5},
        {8, 4},
        {6, 3},
        {12, 7}
    };

    // Method to display all books
    static void displayBooks() {
        System.out.println("\nBooks Available in Library:");

        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }

    // Method to search for a book
    static int searchBook(String name) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // Overloaded method to issue books
    static void issueBook(int available) {
        if (available > 0) {
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is not available.");
        }
    }

    static void issueBook(String name, int available) {
        System.out.println("Book: " + name);
        issueBook(available);
    }

    // Recursive method to calculate total copies
    static int totalCopies(int[] copies, int index) {
        if (index == copies.length) {
            return 0;
        }
        return copies[index] + totalCopies(copies, index + 1);
    }

    // Method to display book copy details using 2D array
    static void displayCopies() {
        System.out.println("\nBook Copy Details:");

        for (int i = 0; i < books.length; i++) {
            System.out.println(
                books[i] + " - Shelf A: " + bookCopies[i][0]
                + ", Shelf B: " + bookCopies[i][1]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        displayBooks();

        System.out.print("\nEnter book name to search: ");
        String name = sc.nextLine();

        int index = searchBook(name);

        if (index != -1) {
            int available =
                bookCopies[index][0] + bookCopies[index][1];

            issueBook(name, available);
        } else {
            System.out.println("Book not found.");
        }

        displayCopies();

        int total = 0;
        for (int i = 0; i < bookCopies.length; i++) {
            total += totalCopies(bookCopies[i], 0);
        }

        System.out.println("\nTotal book copies: " + total);

        sc.close();
    }
}
```

