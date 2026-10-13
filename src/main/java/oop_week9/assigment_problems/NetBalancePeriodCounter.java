package main.java.oop_week9.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class NetBalancePeriodCounter {
    public static int countPeriods(int[] transactions, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for (int tx : transactions) {
            currentSum += tx;
            int target = currentSum - k;
            if (freqMap.containsKey(target)) {
                count += freqMap.get(target);
            }
            freqMap.put(currentSum, freqMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}