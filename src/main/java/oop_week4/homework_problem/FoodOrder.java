package main.java.oop_week4.assigment_problems;
import java.util.*;

public class FoodOrder {
    String studentName;
    String dishName;
    boolean isDelivered;

    public FoodOrder(String studentName, String dishName) {
        if (studentName == null || studentName.trim().isEmpty() || dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.isDelivered = false;
    }

    public void markDelivered() {
        if (isDelivered) {
            System.out.println("Warning: Order for " + studentName + " (" + dishName + ") is already marked as delivered!");
        } else {
            isDelivered = true;
            System.out.println("Order delivered to " + studentName);
        }
    }

    public static void processBatch(String[][] rawOrders) {
        int valid = 0, rejected = 0;
        for (String[] order : rawOrders) {
            try {
                new FoodOrder(order[0], order[1]);
                valid++;
            } catch (Exception e) {
                rejected++;
            }
        }
        System.out.println("Valid: " + valid + " | Rejected: " + rejected);
    }

    public static void main(String[] args) {
        String[][] batch = {{"Ravi", "Paneer Butter Masala"}, {"", "Chole Bhature"}, {"Meera", " "}, {"Divya", "Veg Biryani"}};
        processBatch(batch);
    }
}