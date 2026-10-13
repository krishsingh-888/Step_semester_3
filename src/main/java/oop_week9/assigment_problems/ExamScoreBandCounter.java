package main.java.oop_week9.assigment_problems;

public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int first = findFirst(scores, low);
        if (first == -1) return 0;
        int last = findLast(scores, high);
        return last - first + 1;
    }

    private static int findFirst(int[] arr, int target) {
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
        return (res < arr.length && res != -1 && arr[res] >= target) ? res : -1;
    }

    private static int findLast(int[] arr, int target) {
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
        return (res >= 0 && arr[res] <= target) ? res : -1;
    }
}