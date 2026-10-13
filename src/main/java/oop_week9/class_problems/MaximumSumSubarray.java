package main.java.oop_week9.class_problems;

public class MaximumSumSubarray {
    public static int maxSumSubarray(int[] sales, int k) {
        if (sales == null || sales.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input or k");
        }

        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += sales[i];
        }

        int maxSum = currentSum;
        for (int i = k; i < sales.length; i++) {
            currentSum += sales[i] - sales[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}