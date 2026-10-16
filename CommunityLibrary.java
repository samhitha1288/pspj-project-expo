```java
import java.util.Scanner;

class CommunityLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Book details
        String bookName;
        String memberName;
        int totalBooks = 50;
        int availableBooks = 30;

        // Read member and book details
        System.out.print("Enter member name: ");
        memberName = sc.nextLine();

        System.out.print("Enter book name: ");
        bookName = sc.nextLine();

        System.out.print("Enter number of books required: ");
        int requiredBooks = sc.nextInt();

        // Check book availability
        System.out.println("\n--- Community Library ---");
        System.out.println("Member Name: " + memberName);
        System.out.println("Book Name: " + bookName);
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Available Books: " + availableBooks);

        if (requiredBooks > 0 && requiredBooks <= availableBooks) {
            availableBooks = availableBooks - requiredBooks;

            System.out.println("Status: Books issued successfully!");
            System.out.println("Books Issued: " + requiredBooks);
            System.out.println("Remaining Books: " + availableBooks);
        } else {
            System.out.println("Status: Invalid request or books unavailable.");
        }

        sc.close();
    }
}
```
    
