package service;

import domain.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HotelChain {

    private final String name;
    private Hotel hotel;

    private final Map<String, ReserverPayer> reserverPayers = new HashMap<>();

    public HotelChain(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("HotelChain name cannot be null or empty");
        }
        this.name = name;
    }

    public void setHotel(Hotel hotel) {
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel cannot be null");
        }
        this.hotel = hotel;
    }

    // =========================
    // USE CASE: makeReservation
    // =========================
    public Reservation makeReservation(
            LocalDate reservationDate,
            LocalDate startDate,
            LocalDate endDate,
            RoomType roomType,
            String reserverId,
            String reserverName,
            String reserverAddress,
            String creditCardDetails
    ) {

        // Defensive checks
        if (hotel == null) {
            throw new IllegalStateException("No hotel registered in chain");
        }
        if (roomType == null) {
            throw new IllegalArgumentException("Room type cannot be null");
        }

        // Find or create ReserverPayer
        ReserverPayer reserverPayer = reserverPayers.get(reserverId);
        if (reserverPayer == null) {
            reserverPayer = new ReserverPayer(
                    reserverName,
                    reserverAddress,
                    creditCardDetails,
                    reserverId
            );
            reserverPayers.put(reserverId, reserverPayer);
        }

        // Create reservation
        Reservation reservation = new Reservation(
                reservationDate,
                startDate,
                endDate,
                generateReservationNumber()
        );

        // Assign reserver
        reservation.setReserverPayer(reserverPayer);

        // Reserve a room (simple strategy: first free room)
        Room reservedRoom = hotel.findFreeRoomByType(roomType);
        reservedRoom.reserve();

        hotel.addReservation(reservation);

        return reservation;
    }

    private int generateReservationNumber() {
        return (int) (Math.random() * 10_000);
    }

    // =========================
// USE CASE: cancelReservation
// =========================
public void cancelReservation(Reservation reservation) {

    if (reservation == null) {
        throw new IllegalArgumentException("Reservation cannot be null");
    }

    if (hotel == null) {
        throw new IllegalStateException("No hotel registered in chain");
    }

    hotel.removeReservation(reservation);
}

}
