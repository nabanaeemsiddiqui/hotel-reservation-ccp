package domain;

public class HowMany {

    private final int number;

    public HowMany(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number of rooms must be positive");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
