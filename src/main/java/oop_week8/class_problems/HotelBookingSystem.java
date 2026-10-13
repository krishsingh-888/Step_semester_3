package main.java.oop_week8.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Room {
    private String roomNumber;
    private String category;
    public Room(String roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
    }
    public String getCategory() { return category; }
}

class Reservation {
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean cancelled = false;

    public Reservation(Room room, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean overlaps(LocalDate start, LocalDate end) {
        return !(endDate.isBefore(start) || startDate.isAfter(end));
    }

    public void cancel() { this.cancelled = true; }
    public boolean isCancelled() { return cancelled; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
}

class BookingManager {
    private List<Reservation> reservations = new ArrayList<>();

    public boolean bookRoom(Room room, LocalDate start, LocalDate end) {
        for (Reservation r : reservations) {
            if (!r.isCancelled() && r.overlaps(start, end)) {
                return false; // Overlapping active reservation
            }
        }
        reservations.add(new Reservation(room, start, end));
        return true;
    }
}

public class HotelBookingSystem {
    // Hotel Booking and Cancellation System container
}