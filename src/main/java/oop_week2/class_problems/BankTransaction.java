package main.java.oop_week2.class_problems;

public class BankTransaction {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }
    public static void validateAndFormat(String reference) {
        if (reference.length() != 14) {
            System.out.println("Invalid: wrong length"); return;
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                System.out.println("Invalid: bank code must be 3 letters"); return;
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                System.out.println("Invalid: non-digit body"); return;
            }
        }
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 5) + "/" + reference.substring(5, 7) + "/" + reference.substring(7, 9);
        String seq = reference.substring(9, 14);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ").append(date).append(" | SEQ: ").append(seq);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        validateAndFormat(normalizeReference(" hdf03022600042 "));
        validateAndFormat(normalizeReference("12F03022600042"));
    }
}