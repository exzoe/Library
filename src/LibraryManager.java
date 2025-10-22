import Errors.BookNotFoundException;
import Errors.ClosetNotFoundException;
import Errors.RoomNotFoundException;
import Errors.ShelfNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Book findBookById(String bookId) {
        return rooms.stream()
                .flatMap(room -> room.getClosets().stream())
                .flatMap(closet -> closet.getShelfs().stream())
                .map(shelf -> shelf.findBookById(bookId))
                .filter(book -> book != null)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Книги с ID " + bookId + " не найдено"));
    }

    public Book findBookByTitle(String bookTitle) {
        return rooms.stream()
                .flatMap(room -> room.getClosets().stream())
                .flatMap(closet -> closet.getShelfs().stream())
                .map(shelf -> shelf.findBookByTitle(bookTitle))
                .filter(book -> book != null)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Книги с названием '" + bookTitle + "' не найдено"));
    }

    public Room findRoomById(int roomId) {
        return rooms.stream()
                .filter(room -> room.getRoomId() == roomId)
                .findFirst()
                .orElseThrow(() -> new RoomNotFoundException("Комнаты с ID " + roomId + " не существует"));
    }

    public void addBookToLocation(Book book, int roomId, int closetId, int shelfId) {
        Room targetRoom = findRoomById(roomId);

        Closet targetCloset = targetRoom.getClosets().stream()
                .filter(closet -> closet.getClosetId() == closetId)
                .findFirst()
                .orElseThrow(() -> new ClosetNotFoundException("Шкафа с ID " + closetId + " нет в комнате " + roomId));

        Shelf targetShelf = targetCloset.getShelfs().stream()
                .filter(shelf -> shelf.getShelfId() == shelfId)
                .findFirst()
                .orElseThrow(() -> new ShelfNotFoundException("Полки с ID " + shelfId + " нет в шкафу " + closetId));

        targetShelf.addBook(book);
    }
}