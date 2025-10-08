import java.util.ArrayList;
import java.util.List;

public class Room { 
    private List<Closet> closets = new ArrayList<>();
    private final int roomId;

    public Room(List<Closet> closets, int roomId) {
        this.closets = closets;
        this.roomId = roomId;
    }

    public Room(int roomId) {
        this.roomId = roomId;
    }

    public List<Closet> getClosets() {
        return closets;
    }
    public int getRoomId() {
        return roomId;
    }

    public void addCloset(Closet closet) {
        closets.add(closet);
    }

    public void removeCloset(Closet closet) {
        closets.remove(closet);
    }

    public Closet findClosetById(int closetId) {
        for (Closet closet : closets) {
            if (closet.getClosetId() == closetId) {
                return closet;
            }
        }
        throw new IllegalArgumentException("Шкафа с ID " + closetId + " в комнате " + roomId + " не существует");
    }
}
