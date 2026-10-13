package main.java.oop_week9.assigment_problems;

public class LongestBudgetFriendlyStreak {
    public static int[] longestStreak(int[] costs, int budget) {
        int left = 0, currentSum = 0;
        int maxLength = 0, bestStart = 0;

        for (int right = 0; right < costs.length; right++) {
            currentSum += costs[right];
            while (currentSum > budget) {
                currentSum -= costs[left];
                left++;
            }
            int windowLength = right - left + 1;
            if (windowLength > maxLength) {
                maxLength = windowLength;
                bestStart = left;
            }
        }
        if (maxLength == 0) {
            return new int[]{0, -1};
        }
        return new int[]{maxLength, bestStart};
    }
}