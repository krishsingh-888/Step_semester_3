package main.java.oop_week2.class_problems;

public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
                else consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }
    public static void main(String[] args) { countVowelsAndConsonants("Java Programming"); }
}