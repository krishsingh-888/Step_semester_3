package main.java.oop_week6.assigment_problems;

class SettlableRaceEntry {
    String bibNumber;
    double entryFee;
    final String entryCode;
    private static int bibCounter = 1000;

    public SettlableRaceEntry(String bibNumber, double entryFee) {
        this.bibNumber = bibNumber;
        this.entryFee = entryFee;
        this.entryCode = "ENTRY-" + (bibCounter++);
    }

    public void pay(double amount) {
        this.entryFee -= amount;
    }

    public void pay(double amount, String mode) {
        pay(amount);
        // Additional mode logic goes here
    }

    public static boolean isValidDiscountCode(String code) {
        if (code == null || code.length() != 5) return false;
        if (code.charAt(0) != 'M') return false;
        for (int i = 1; i <= 3; i++) {
            if (!Character.isDigit(code.charAt(i))) return false;
        }
        return Character.isUpperCase(code.charAt(4));
    }

    public static int getBibCounter() {
        return bibCounter;
    }
}

class SettlableRelayTeamEntry extends SettlableRaceEntry {
    public SettlableRelayTeamEntry(String bibNumber, double entryFee) {
        super(bibNumber, entryFee);
    }
}

public class NightlySettlementEngine {
    public static String settleNight(SettlableRaceEntry[] entries) {
        int relay = 0, regular = 0, skipped = 0;
        for (SettlableRaceEntry e : entries) {
            if (e == null) {
                skipped++;
                continue;
            }
            if (e instanceof SettlableRelayTeamEntry) {
                relay++;
            } else {
                regular++;
            }
        }
        return "Processed. Relay: " + relay + ", Regular: " + regular + ", Skipped: " + skipped;
    }
}