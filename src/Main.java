public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(1);
        Closet closet1 = new Closet(1);
        Shelf shelf1 = new Shelf(1);

        Book book1 = new Book("Ракамакафо", "Бочаров С. С.", 230, 1);
        Book book2 = new Book("Таракан", "Гыгун Р. А.", 100, 2);


        shelf1.addBook(book1);
        closet1.addShelf(shelf1);
        room1.addCloset(closet1);

        LibraryManager libman = new LibraryManager();
        libman.addRoom(room1);

        System.out.println(libman.findBookEverywhere(1));
        libman.addBookToLocation(book2, 1, 1, 1);
        System.out.println(libman.findBookEverywhere(2));
    }
}