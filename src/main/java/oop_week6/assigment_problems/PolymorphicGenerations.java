package main.java.oop_week6.assigment_problems;

class EliteEntry extends RunnerEntry {
    public EliteEntry(String bibNumber, double entryFee, String category) {
        super(bibNumber, entryFee, category);
    }
}

class RelayTeamEntry extends RaceEntry {
    int teamSize;
    public RelayTeamEntry(String bibNumber, double entryFee, int teamSize) {
        super(bibNumber, entryFee);
        this.teamSize = teamSize;
    }
}

public class PolymorphicGenerations {
    public static String classifyGeneration(RaceEntry entry) {
        if (entry instanceof EliteEntry) {
            return "Multilevel descendant (3 generations deep)";
        } else if (entry instanceof RelayTeamEntry) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Standard entry";
    }

    public static double getTotalBalanceDue(RaceEntry[] entries) {
        double total = 0;
        for (RaceEntry entry : entries) {
            if (entry != null) {
                total += entry.getBalanceDue();
            }
        }
        return total;
    }
}