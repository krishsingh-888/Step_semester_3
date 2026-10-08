package main.java.oop_week7.class_problems;

abstract class PaymentMethod {
    private static int counter = 1001;
    private final String transactionId;

    public PaymentMethod() {
        this.transactionId = "TXN-" + (counter++);
    }

    public abstract String processPayment(double amount);

    public String processPayment(double amount, String note) {
        return processPayment(amount) + " (" + note + ")";
    }

    public String getTransactionId() {
        return transactionId;
    }
}

class CreditCardPayment extends PaymentMethod {
    private String cardNumberLastFour;
    
    public CreditCardPayment(String cardNumberLastFour) {
        this.cardNumberLastFour = cardNumberLastFour;
    }
    
    @Override
    public String processPayment(double amount) {
        return "Charged $" + amount + " to card ending " + cardNumberLastFour + " - Txn " + getTransactionId();
    }
}

class CashPayment extends PaymentMethod {
    @Override
    public String processPayment(double amount) {
        return "Received $" + amount + " in cash - Txn " + getTransactionId();
    }
}

public class CheckoutPaymentHandler {
    public static void printConfirmation(PaymentMethod payment, double amount) {
        System.out.println(payment.processPayment(amount));
    }
    
    public static void testUpcasting() {
        // Upcasting: A CreditCardPayment object is stored in a reference variable of its parent type (PaymentMethod)
        PaymentMethod cc = new CreditCardPayment("4471"); 
        printConfirmation(cc, 250.0);
    }
}