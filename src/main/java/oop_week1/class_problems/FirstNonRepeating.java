package main.java.oop_week1.class_problems;

public class FirstNonRepeating {
    public static void findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) freq[c]++;
        
        for (char c : text.toCharArray()) {
            if (freq[c] == 1) {
                System.out.println("First Non-Repeating Character: '" + c + "'");
                return;
            }
        }
        System.out.println("No Non-Repeating Character Found");
    }

    public static void main(String[] args) {
        findFirstNonRepeatingChar("swiss");
        findFirstNonRepeatingChar("aabbcc");
    }
}