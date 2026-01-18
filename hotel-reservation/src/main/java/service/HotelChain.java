package service;

import domain.Guest;
import domain.Hotel;
import domain.ReserverPayer;

import java.util.HashMap;
import java.util.Map;

public class HotelChain {

    private final String name;

    private Hotel hotel; // 0..1
    private final Map<String, Guest> guests = new HashMap<>();
    private final Map<String, ReserverPayer> reserverPayers = new HashMap<>();

    public HotelChain(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("HotelChain name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
