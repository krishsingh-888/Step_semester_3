package main.java.oop_week6.assigment_problems;
import java.util.Arrays;

class AuditedRaceEntry {
    String bibNumber;
    double entryFee;
    private double[] lateFeeHistory;
    private int penaltyCount;

    public AuditedRaceEntry(String bibNumber, double entryFee) {
        this.bibNumber = bibNumber;
        this.entryFee = entryFee;
        this.lateFeeHistory = new double[50];
        this.penaltyCount = 0;
    }

    protected void applyLateFee(double amount) {
        this.entryFee += amount;
        if (penaltyCount < lateFeeHistory.length) {
            lateFeeHistory[penaltyCount++] = amount;
        }
    }

    public double[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, penaltyCount);
    }
    
    public double getBalanceDue() {
        return entryFee;
    }
}

class AuditedRunnerEntry extends AuditedRaceEntry {
    String category;

    public AuditedRunnerEntry(String bibNumber, double entryFee, String category) {
        super(bibNumber, entryFee);
        this.category = category;
    }

    @Override
    protected void applyLateFee(double amount) {
        super.applyLateFee(amount * 2);
    }
}

public class PenaltyAuditTrail {
    // Audit implementation classes provided above
}