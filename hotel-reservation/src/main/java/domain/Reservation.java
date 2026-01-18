package domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Reservation {

    private final LocalDate reservationDate;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int number;

    private ReserverPayer reserverPayer; // 0..1
    private final Map<RoomType, HowMany> roomTypeQuantities = new HashMap<>();

    public Reservation(LocalDate reservationDate, LocalDate startDate, LocalDate endDate, int number) {
        if (reservationDate == null || startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (!startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("Reservation number must be positive");
        }

        this.reservationDate = reservationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setReserverPayer(ReserverPayer reserverPayer) {
    if (reserverPayer == null) {
        throw new IllegalArgumentException("ReserverPayer cannot be null");
    }
    this.reserverPayer = reserverPayer;
}

}
