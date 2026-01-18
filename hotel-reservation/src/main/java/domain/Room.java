package domain;

public class Room {

    private final int number;
    private Guest occupant; // 0..1 occupant
    private State state;

    // Room state as per UML state diagram
    public enum State {
        FREE,
        RESERVED,
        OCCUPIED
    }

    public Room(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Room number must be positive");
        }
        this.number = number;
        this.state = State.FREE; // initial state
    }

    public int getNumber() {
        return number;
    }

    public Guest getOccupant() {
        return occupant;
    }

    public State getState() {
        return state;
    }

    public boolean isFree() {
        return state == State.FREE;
    }

    // FREE -> RESERVED
    public void reserve() {
        if (state != State.FREE) {
            throw new IllegalStateException("Room must be free to reserve");
        }
        state = State.RESERVED;
    }

    // RESERVED -> OCCUPIED
    public void checkIn(Guest guest) {
        if (state != State.RESERVED) {
            throw new IllegalStateException("Room must be reserved before check-in");
        }
        if (guest == null) {
            throw new IllegalArgumentException("Guest cannot be null");
        }
        this.occupant = guest;
        state = State.OCCUPIED;
    }

    // OCCUPIED -> FREE
    public void checkOut() {
        if (state != State.OCCUPIED) {
            throw new IllegalStateException("Room must be occupied to check out");
        }
        this.occupant = null;
        state = State.FREE;
    }
}
