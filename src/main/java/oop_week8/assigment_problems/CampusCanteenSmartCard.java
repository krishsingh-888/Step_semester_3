package main.java.oop_week8.assigment_problems;

import java.util.ArrayList;
import java.util.List;

interface PricingPlan {
    double calculatePrice(double basePrice);
}

class DayScholarPlan implements PricingPlan {
    @Override
    public double calculatePrice(double basePrice) { return basePrice; }
}

class HostellerPlan implements PricingPlan {
    @Override
    public double calculatePrice(double basePrice) { return basePrice * 0.90; } // 10% off
}

class StaffPlan implements PricingPlan {
    @Override
    public double calculatePrice(double basePrice) { return basePrice * 0.80; } // 20% off
}

class SmartCard {
    private String cardId;
    private double balance;
    private PricingPlan plan;
    private boolean isBlocked = false;
    private List<Double> transactionHistory = new ArrayList<>();

    public SmartCard(String cardId, double initialTopUp, PricingPlan plan) {
        if (initialTopUp < 100) throw new IllegalArgumentException("Minimum top-up is ₹100");
        this.cardId = cardId;
        this.balance = initialTopUp;
        this.plan = plan;
    }

    public void purchase(double basePrice) {
        if (isBlocked) throw new IllegalStateException("Card is blocked.");
        double finalPrice = plan.calculatePrice(basePrice);
        if (balance - finalPrice < 0) throw new IllegalArgumentException("Insufficient balance.");
        balance -= finalPrice;
        transactionHistory.add(-finalPrice);
    }

    public double getBalance() { return balance; }
}

public class CampusCanteenSmartCard {
    // Campus Canteen Smart Card container
}