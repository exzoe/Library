public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        Room room1 = new Room(1);
        Closet closet1 = new Closet(1);
        Shelf shelf1 = new Shelf(1);
        Shelf shelf2 = new Shelf(2);

        Book book1 = new Book("Вакамакафо", "Рыран С. С.", 230);
        Book book2 = new Book("Ааракан", "Гыгун Р. А.", 100);
        Book book3 = new Book("Банак", "Рыра А. А.", 100);


        shelf1.addBook(book1);
        shelf1.addBook(book3);
        closet1.addShelf(shelf1);
        closet1.addShelf(shelf2);
        room1.addCloset(closet1);
        libraryManager.addRoom(room1);
        libraryManager.addBookToLocation(book2, 1, 1, 1);

        ConsoleInterface consoleInterface = new ConsoleInterface(libraryManager);
        consoleInterface.start();

    }
}