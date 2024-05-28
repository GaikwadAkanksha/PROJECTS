import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    if (library.books.isEmpty()) {
                        System.out.println("No books to remove. Library is empty.");
                    } else {
                        System.out.println("Enter the title of the book to remove: ");
                        String removeTitle = scanner.nextLine();
                        boolean found = false;
                        for (Book book : library.books) {
                            if (book.getTitle().equalsIgnoreCase(removeTitle)) {
                                library.removeBook(book);
                                found = true;
                                System.out.println("Book removed successfully.");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Book not found.");
                        }
                    }
                    break;
                case 3:
                    if (library.books.isEmpty()) {
                        System.out.println("No books available. Library is empty.");
                    } else {
                        library.displayBooks();
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
