package main.java.oop_week4.assigment_problems;

class DeliveryAccount {
    String studentId;
    double orderValue;
    static double flatSurgeRate;

    static {
        flatSurgeRate = 20.0;
    }

    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = studentId;
        this.orderValue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 500.0);
    }

    public final double calculateSurgeFee(int delayMinutes) {
        return delayMinutes > 0 ? flatSurgeRate : 0.0;
    }
}

class PremiumAccount extends DeliveryAccount {
    public PremiumAccount(String studentId, double orderValue) {
        super(studentId, orderValue);
    }
}

public class MultiKitchenReconciliation {
    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        int processed = 0, nullSkipped = 0, premium = 0, regular = 0;
        double grandTotalSurge = 0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                nullSkipped++;
                continue;
            }
            int delay = (i < delayMinutesArray.length) ? delayMinutesArray[i] : 0;
            grandTotalSurge += accounts[i].calculateSurgeFee(delay);
            
            if (accounts[i] instanceof PremiumAccount) premium++;
            else regular++;
            
            processed++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + premium + " premium | " + regular + " regular | grand total surge fees = Rs " + grandTotalSurge);
    }

    public static void main(String[] args) {
        DeliveryAccount[] accounts = { new PremiumAccount("STU001", 500), null, new DeliveryAccount("STU002", 300) };
        double[] amounts = {500, 400, 300};
        int[] delayMinutesArray = {10, 5, 0};
        processBatch(accounts, amounts, delayMinutesArray);
    }
}