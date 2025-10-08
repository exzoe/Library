import java.util.ArrayList;
import java.util.List;

public class Closet { 
    private List<Shelf> shelfs = new ArrayList<>();
    private final int closetId;

    public Closet(List<Shelf> shelfs, int closetId) {
        this.shelfs = shelfs;
        this.closetId = closetId;
    }

    public Closet(int closetId) {
        this.closetId = closetId;
    }

    public List<Shelf> getShelfs() {
        return shelfs;
    }
    public int getClosetId() {
        return closetId;
    }

    public void addShelf(Shelf shelf) {
        shelfs.add(shelf);
    }

    public void removeShelf(Shelf shelf) {
        shelfs.remove(shelf);
    }

    public Shelf findShelfById(int shelfId) {
        for (Shelf shelf : shelfs) {
            if (shelf.getShelfId() == shelfId) {
                return shelf;
            }
        }
        throw new IllegalArgumentException("Полки с ID " + shelfId + " в шкафу " + closetId + " не существует");
    }
}
