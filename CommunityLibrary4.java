import java.util.Scanner;

class InvalidBookException extends Exception {
    InvalidBookException(String message) {
        super(message);
    }
}

interface LibraryOperations {
    void displayDetails();
    void issueBook() throws InvalidBookException;
    void returnBook();
}

class Book implements LibraryOperations {
    private String bookName;
    private String author;
    private int availableCopies;

    Book() {
        this("Unknown", "Unknown", 0);
    }

    Book(String bookName, String author, int availableCopies) {
        this.bookName = bookName;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public String getBookName() {
        return bookName;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public void displayDetails() {
        System.out.println(this);
    }

    @Override
    public void issueBook() throws InvalidBookException {
        if (availableCopies <= 0) {
            throw new InvalidBookException("Book is not available.");
        }
        availableCopies--;
        System.out.println("Book issued successfully.");
    }

    @Override
    public void returnBook() {
        availableCopies++;
        System.out.println("Book returned successfully.");
    }

    @Override
    public String toString() {
        return "Book: " + bookName + ", Author: " + author
                + ", Available Copies: " + availableCopies;
    }
}

class Member {
    private String memberName;
    private int memberId;

    Member(String memberName, int memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public void displayMember() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Member ID: " + memberId);
    }
}

public class CommunityLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book book = new Book("Java Programming", "James Gosling", 5);

        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        System.out.print("Enter member ID: ");
        int id = sc.nextInt();

        Member member = new Member(name, id);

        try {
            member.displayMember();
            book.displayDetails();

            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    book.issueBook();
                    break;

                case 2:
                    book.returnBook();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            book.displayDetails();

        } catch (InvalidBookException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            sc.close();
            System.out.println("Thank you for using the library system.");
        }
    }
}