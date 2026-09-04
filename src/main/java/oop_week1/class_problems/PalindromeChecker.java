package main.java.oop_week1.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        String reversed = "";
        for (int i = arr.length - 1; i >= 0; i--) reversed += arr[i];
        return text.equals(reversed);
    }

    public static void main(String[] args) {
        String[] tests = {"madam", "hello"};
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Iterative: " + (isPalindromeIterative(test) ? "Palindrome" : "Not Palindrome"));
            System.out.println("Recursive: " + (isPalindromeRecursive(test) ? "Palindrome" : "Not Palindrome"));
            System.out.println("Array Reversal: " + (isPalindromeArrayReversal(test) ? "Palindrome" : "Not Palindrome"));
            System.out.println("---");
        }
    }
}