package domain;

public class Room {

    private final int number;
    private Guest occupant; // 0..1

    public Room(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Room number must be positive");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Guest getOccupant() {
        return occupant;
    }
}
