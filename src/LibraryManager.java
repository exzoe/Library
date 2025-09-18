import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }
    public Book findBookEverywhere(int bookId) {
        for (Room room : rooms) {
            for (Closet closet : room.getClosets()) {
                for (Shelf shelf : closet.getShelfs()) {
                    Book book = shelf.findBookById(bookId);
                    if (book != null) {
                        return book;
                    }
                }
            }
        }
        return null;
    }

    public void addBookToLocation(Book book, int roomId, int closetId, int shelfId) {
        Room targetRoom = null;
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                targetRoom = room;
                break;
            }
        }
        if (targetRoom == null) {
            throw new IllegalArgumentException("Комнаты с ID " + roomId + " не существует");
        }

        Closet targetCloset = null;
        for (Closet closet : targetRoom.getClosets()) {
            if (closet.getClosetId() == closetId) {
                targetCloset = closet;
                break;
            }
        }
        if (targetCloset == null) {
            throw new IllegalArgumentException("Шкафа с ID " + closetId + " нет в комнате " + roomId);
        }

        Shelf targetShelf = null;
        for (Shelf shelf : targetCloset.getShelfs()) {
            if (shelf.getShelfId() == shelfId) {
                targetShelf = shelf;
                break;
            }
        }
        if (targetShelf == null) {
            throw new IllegalArgumentException("Полки с ID " + shelfId + " нет в шкафу " + closetId);
        }

        targetShelf.addBook(book);
    }
}
