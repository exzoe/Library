public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(1);
        Closet closet1 = new Closet(1);
        Shelf shelf1 = new Shelf(1);

        Book book1 = new Book("Ракамакафо", "Бочаров С. С.", 230, 1);

        shelf1.addBook(book1);
        closet1.addShelf(shelf1);
        room1.addCloset(closet1);

        Book found = room1.findClosetById(1).findShelfById(1).findBookById(1);
        System.out.println(found);
    }
}