package main.java.oop_week4.assigment_problems;

public class BoardingPenaltyCalculator {
    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) throw new IllegalArgumentException("Negative values not allowed");
        if (minutesLate == 0) return 0.0;

        double rate = 0.0;
        if (minutesLate >= 1 && minutesLate <= 5) rate = 0.005;
        else if (minutesLate >= 6 && minutesLate <= 15) rate = 0.01;
        else if (minutesLate >= 16) rate = 0.02;

        double calculatedPenalty = ticketFare * (rate * minutesLate);
        double minPenaltyFloor = ticketFare * (minimumPenaltyPercent / 100.0);

        return Math.max(calculatedPenalty, minPenaltyFloor);
    }

    public static void main(String[] args) {
        BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0);
        System.out.println("Rs " + calc.calculatePenalty(1000, 0));
        System.out.println("Rs " + calc.calculatePenalty(1000, 1));
        System.out.println("Rs " + calc.calculatePenalty(1000, 16));
    }
}