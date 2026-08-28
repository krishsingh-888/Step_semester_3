package oop_week3.class_problems;

public class FeeAccount {
    private String regNo;
    private double totalFee;
    private double amountPaid;

    public FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = 0;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment.");
            return;
        }
        this.amountPaid += amount;
    }

    public double getDue() {
        return this.totalFee - this.amountPaid;
    }

    public void payInTwoInstallments(double amount) {
        pay(amount / 2);
        pay(amount / 2);
    }

    public double effectiveDue(double scholarshipPercent) {
        return getDue() - (getDue() * (scholarshipPercent / 100));
    }

    public static void main(String[] args) {
        FeeAccount accountA = new FeeAccount("101", 200000);
        accountA.payInTwoInstallments(120000);
        System.out.println("Account A due: Rs " + accountA.getDue());

        FeeAccount accountB = new FeeAccount("102", 180000);
        System.out.println("Account B effective due (20% scholarship): Rs " + 
                           accountB.effectiveDue(20));
    }
}