package domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private final String name;

    private final List<Room> rooms = new ArrayList<>();
    private final List<RoomType> roomTypes = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public Hotel(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Hotel name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addReservation(Reservation reservation) {
    if (reservation == null) {
        throw new IllegalArgumentException("Reservation cannot be null");
    }
    reservations.add(reservation);
}

public Room findFreeRoomByType(RoomType roomType) {
    for (Room room : rooms) {
        if (room.isFree()) {
            return room;
        }
    }
    throw new IllegalStateException("No free room available");
}

public void removeReservation(Reservation reservation) {
    if (reservation == null) {
        throw new IllegalArgumentException("Reservation cannot be null");
    }

    if (!reservations.remove(reservation)) {
        throw new IllegalStateException("Reservation does not exist");
    }
}


}
