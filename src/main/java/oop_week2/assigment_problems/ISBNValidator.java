package main.java.oop_week2.assigment_problems;

public class ISBNValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed; 
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static void validateAndFormat(String code) {
        if (code.length() != 13) {
            System.out.println("Invalid: wrong length");
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                return;
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                System.out.println("Invalid: non-digit body");
                return;
            }
        }
        
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        validateAndFormat(normalizeCode(" pen2026004251 "));
        validateAndFormat(normalizeCode("12N2026004251"));
    }
}