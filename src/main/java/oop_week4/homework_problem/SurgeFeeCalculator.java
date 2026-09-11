package main.java.oop_week4.assigment_problems;

public class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) throw new IllegalArgumentException("Negative values not allowed");
        if (delayMinutes == 0) return 0.0;

        double surge = 0.0;
        
        // Tier 1: 1-5 mins @ 0.5%
        if (delayMinutes >= 1) {
            int tier1Mins = Math.min(delayMinutes, 5);
            surge += orderValue * (0.005 * tier1Mins);
        }
        // Tier 2: 6-15 mins @ 1.0%
        if (delayMinutes >= 6) {
            int tier2Mins = Math.min(delayMinutes - 5, 10);
            surge += orderValue * (0.01 * tier2Mins);
        }
        // Tier 3: 16+ mins @ 2.0%
        if (delayMinutes >= 16) {
            int tier3Mins = delayMinutes - 15;
            surge += orderValue * (0.02 * tier3Mins);
        }

        double minFloor = orderValue * (minimumSurgePercent / 100.0);
        return Math.max(surge, minFloor); // Applies flat minimum if tiered is lower
    }

    public static void main(String[] args) {
        SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
        System.out.println("Rs " + calc.calculateSurgeFee(500, 0));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 1));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 16));
    }
}