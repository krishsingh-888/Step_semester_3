package main.java.oop_week8.class_problems;

import java.util.ArrayList;
import java.util.List;

interface IPaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements IPaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return true; // Simulation success
    }
}

class DigitalWalletPayment implements IPaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return false; // Simulation failure test case
    }
}

class LineItem {
    String itemName;
    double price;
    int quantity;
    public LineItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public double getTotal() { return price * quantity; }
}

class FoodOrder {
    private List<LineItem> items = new ArrayList<>();
    
    public void addItem(LineItem item) {
        items.add(item);
    }

    public boolean checkout(IPaymentMethod paymentMethod) {
        if (items.isEmpty()) return false;
        double total = 0;
        for (LineItem item : items) total += item.getTotal();
        return paymentMethod.processPayment(total);
    }
}

public class FoodOrderSystem {
    // Food Order and Flexible Payment System container
}