package main.java.oop_week6.assigment_problems;

class AnnouncableRaceEntry {
    String bibNumber;
    double entryFee;
    
    public AnnouncableRaceEntry(String bibNumber, double entryFee) {
        this.bibNumber = bibNumber;
        this.entryFee = entryFee;
    }
    
    public double getBalanceDue() { return entryFee; }
    
    public String announce() {
        return "Runner Entry | Bib: " + bibNumber + " | Category: Open 10K | Balance: " + getBalanceDue();
    }
}

class AnnouncableRelayTeamEntry extends AnnouncableRaceEntry {
    int teamSize;
    
    public AnnouncableRelayTeamEntry(String bibNumber, double entryFee, int teamSize) {
        super(bibNumber, entryFee);
        this.teamSize = teamSize;
    }
    
    public int getTeamSize() { return teamSize; }
    
    @Override
    public String announce() {
        return "Relay Team | Bib: " + bibNumber + " | Balance: " + getBalanceDue();
    }
}

public class AnnouncerBoard {
    public static String announceAll(AnnouncableRaceEntry[] entries) {
        StringBuilder sb = new StringBuilder();
        for (AnnouncableRaceEntry entry : entries) {
            if (entry == null) continue;
            
            sb.append(entry.announce());
            
            if (entry instanceof AnnouncableRelayTeamEntry) {
                AnnouncableRelayTeamEntry relay = (AnnouncableRelayTeamEntry) entry;
                sb.append(" [Team size via downcast: ").append(relay.getTeamSize()).append("] | ");
            } else {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}