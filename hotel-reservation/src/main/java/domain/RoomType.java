package domain;

public class RoomType {

    private final String kind;
    private final double cost;

    public RoomType(String kind, double cost) {
        if (kind == null || kind.isBlank()) {
            throw new IllegalArgumentException("Room type cannot be null or empty");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Room cost must be positive");
        }
        this.kind = kind;
        this.cost = cost;
    }

    public String getKind() {
        return kind;
    }

    public double getCost() {
        return cost;
    }
}
