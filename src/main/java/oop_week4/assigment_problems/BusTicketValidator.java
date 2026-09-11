package main.java.oop_week4.assigment_problems;
import java.util.*;

class BusTicket {
    String passengerName;
    String destination;

    public BusTicket(String passengerName, String destination) {
        if (passengerName == null || passengerName.trim().isEmpty() || destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.passengerName = passengerName;
        this.destination = destination;
    }

    public static void processBatch(String[][] rawBookings) {
        Set<String> accepted = new HashSet<>();
        int valid = 0, rejected = 0, duplicates = 0;

        for (String[] booking : rawBookings) {
            try {
                BusTicket ticket = new BusTicket(booking[0], booking[1]);
                String key = ticket.passengerName + "-" + ticket.destination;
                if (accepted.contains(key)) {
                    duplicates++;
                } else {
                    accepted.add(key);
                    valid++;
                }
            } catch (Exception e) {
                rejected++;
            }
        }
        System.out.println("Valid: " + valid + " | Rejected: " + rejected + " | Duplicates skipped: " + duplicates);
    }
}

public class BusTicketValidator {
    public static void main(String[] args) {
        String[][] batch = {{"Divya", "Chennai"}, {"", "Bangalore"}, {"Ravi123", "Pune"}, {"Divya", "Chennai"}, {" ", " "}};
        BusTicket.processBatch(batch);
    }
}