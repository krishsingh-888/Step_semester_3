package main.java.oop_week4.assigment_problems;
import java.util.Arrays;

public class FareSplitter {
    String tripId;
    double totalFare;
    int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (totalFare < 0 || passengerCount <= 0) throw new IllegalArgumentException("Invalid values");
        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 1);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0.0, 1);
    }

    public double[] fareBreakdown() {
        if (totalFare == 0) return new double[passengerCount];
        double[] shares = new double[passengerCount];
        int totalPaise = (int) Math.round(totalFare * 100);
        int baseShare = totalPaise / passengerCount;
        int remainder = totalPaise % passengerCount;

        for (int i = 0; i < passengerCount; i++) {
            shares[i] = baseShare / 100.0;
            if (i < remainder) shares[i] += 0.01;
        }
        return shares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FareSplitter("TRIP001", 100000, 3).fareBreakdown()));
    }
}