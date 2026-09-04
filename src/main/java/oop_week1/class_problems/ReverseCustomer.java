package main.java.oop_week1.class_problems;

public class ReverseCustomer {
    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        String reversed = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        String original = "Sunil";
        System.out.println("Original Name: " + original);
        System.out.println("Reversed Name: " + reverseCustomerName(original));
    }
}