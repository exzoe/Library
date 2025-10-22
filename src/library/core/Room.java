package library.core;

import library.core.Errors.ClosetNotFoundException;

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
        return closets.stream()
                .filter(closet -> closet.getClosetId() == closetId)
                .findFirst()
                .orElseThrow(() -> new ClosetNotFoundException("Шкафа с ID " + closetId + " в комнате " + roomId + " не существует"));
    }
}