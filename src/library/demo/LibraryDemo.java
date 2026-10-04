package library.demo;

import library.core.*;
import library.core.Errors.*;

public class LibraryDemo {
    public static void main(String[] args) {
        System.out.println("===================================================");

        LibraryManager libraryManager = new LibraryManager();

        Room room1 = new Room(1);
        Closet closet1 = new Closet(1);
        Shelf shelf1 = new Shelf(1);

        Book book1 = new Book("Война и мир", "Лев Толстой", 1225);
        Book book2 = new Book("Преступление и наказание", "Федор Достоевский", 671);

        System.out.println("\nСозданные книги:");
        System.out.println("1. " + book1);
        System.out.println("2. " + book2);

        shelf1.addBook(book1);
        shelf1.addBook(book2);

        closet1.addShelf(shelf1);
        room1.addCloset(closet1);
        libraryManager.addRoom(room1);

        System.out.println("\nСтруктура библиотеки создана!");

        System.out.println("\nПоиск книг:");

        String searchId = book2.getId();
        try {
            Book foundById = libraryManager.findBookById(searchId);
            System.out.println("Найдена по ID '" + searchId + "': " + foundById.getTitle());
        } catch (BookNotFoundException e) {
            System.out.println("Книга не найдена: " + e.getMessage());
        }

        try {
            Book foundByTitle = libraryManager.findBookByTitle("Война и мир");
            System.out.println("Найдена по названию 'Война и мир': " + foundByTitle.getAuthor());
        } catch (BookNotFoundException e) {
            System.out.println("Книга не найдена: " + e.getMessage());
        }

    }
}
