package main.java.oop_week4.assigment_problems;
import java.util.Arrays;

public class Canteen implements Comparable<Canteen> {
    String canteenCode;
    String canteenName;
    int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3); // Sensible default trust score
    }

    @Override
    public int compareTo(Canteen other) {
        // Tie-breaker 1: Trust score (descending)
        if (this.trustScore != other.trustScore) {
            return Integer.compare(other.trustScore, this.trustScore); 
        }
        // Tie-breaker 2: Canteen code (case-insensitive)
        int codeCompare = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if (codeCompare != 0) return codeCompare;
        
        // Tie-breaker 3: Name length
        return Integer.compare(this.canteenName.length(), other.canteenName.length());
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        Canteen[] sorted = canteens.clone();
        Arrays.sort(sorted);
        return sorted;
    }

    public static void main(String[] args) {
        Canteen[] c = {
            new Canteen("HB3-C", "Spice Junction", 3), 
            new Canteen("hb1-c", "Grand Mess", 5), 
            new Canteen("HB2-C", "Southern Treats")
        };
        Canteen[] ranked = rankCanteens(c);
        for (Canteen canteen : ranked) System.out.print("\"" + canteen.canteenCode + "\" ");
    }
}