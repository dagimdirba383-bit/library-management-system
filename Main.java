package library;

import java.util.ArrayList;
import java.util.Scanner;

abstract class LibraryItem {
    private String title;
    private int id;

    public LibraryItem(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    abstract void displayInfo();
}

class Book extends LibraryItem {
    private String author;

    public Book(String title, int id, String author) {
        super(title, id);
        this.author = author;
    }

    @Override
    void displayInfo() {
        System.out.println("Book: " + getTitle());
        System.out.println("ID: " + getId());
        System.out.println("Author: " + author);
    }
}

class Magazine extends LibraryItem {
    private String category;

    public Magazine(String title, int id, String category) {
        super(title, id);
        this.category = category;
    }

    @Override
    void displayInfo() {
        System.out.println("Magazine: " + getTitle());
        System.out.println("ID: " + getId());
        System.out.println("Category: " + category);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<LibraryItem> items = new ArrayList<>();

        try {
            System.out.print("Book title: ");
            String bookTitle = input.nextLine();

            System.out.print("Book ID: ");
            int bookId = input.nextInt();
            input.nextLine();

            System.out.print("Author: ");
            String author = input.nextLine();

            System.out.print("Magazine title: ");
            String magTitle = input.nextLine();

            System.out.print("Magazine ID: ");
            int magId = input.nextInt();
            input.nextLine();

            System.out.print("Category: ");
            String category = input.nextLine();

            items.add(new Book(bookTitle, bookId, author));
            items.add(new Magazine(magTitle, magId, category));

            System.out.println("\nLibrary Items:\n");

            for (LibraryItem item : items) {
                item.displayInfo();
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }

        input.close();
    }
}