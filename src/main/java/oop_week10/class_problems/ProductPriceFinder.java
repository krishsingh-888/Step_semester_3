package main.java.oop_week10.class_problems;

public class ProductPriceFinder {
    public static int countInRange(int[] prices, int lower, int upper) {
        int leftIdx = findLowerIndex(prices, lower);
        int rightIdx = findUpperIndex(prices, upper);
        if (leftIdx == -1 || rightIdx == -1) return 0;
        return rightIdx - leftIdx + 1;
    }

    private static int findLowerIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static int findUpperIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}