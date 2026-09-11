package main.java.oop_week4.assigment_problems;

class BusTicketAccount {
    String bookingId;
    double ticketFare;
    static double flatPenaltyRate;

    static {
        flatPenaltyRate = 50.0;
    }

    public BusTicketAccount(String bookingId, double ticketFare) {
        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 1000.0);
    }

    public final double calculatePenalty(int minutesLate) {
        return minutesLate > 0 ? flatPenaltyRate : 0.0;
    }
}

class SleeperAccount extends BusTicketAccount {
    public SleeperAccount(String bookingId, double ticketFare) {
        super(bookingId, ticketFare);
    }
}

public class FleetReconciliation {
    public static void processBatch(BusTicketAccount[] accounts, int[] minutesLateArray) {
        int processed = 0, nullSkipped = 0, sleeper = 0, regular = 0;
        double grandTotalPenalties = 0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                nullSkipped++;
                continue;
            }
            int lateTime = (i < minutesLateArray.length) ? minutesLateArray[i] : 0;
            grandTotalPenalties += accounts[i].calculatePenalty(lateTime);
            
            if (accounts[i] instanceof SleeperAccount) sleeper++;
            else regular++;
            
            processed++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + sleeper + " sleeper | " + regular + " regular | grand total penalties = Rs " + grandTotalPenalties);
    }

    public static void main(String[] args) {
        BusTicketAccount[] accounts = { new SleeperAccount("BK001", 2000), null, new BusTicketAccount("BK002", 1200) };
        int[] minutesLate = {10, 5, 0};
        processBatch(accounts, minutesLate);
    }
}