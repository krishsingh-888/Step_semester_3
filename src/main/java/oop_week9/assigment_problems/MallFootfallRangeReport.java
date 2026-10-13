package main.java.oop_week9.assigment_problems;

public class MallFootfallRangeReport {
    public static int[] footfallReport(int[] visitors, int[][] queries) {
        int n = visitors.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + visitors[i];
        }

        int[] results = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int start = queries[q][0];
            int end = queries[q][1];
            results[q] = prefixSum[end + 1] - prefixSum[start];
        }
        return results;
    }
}