package main.java.oop_week10.class_problems;

import java.util.Map;

public class StudentMarksGrid {
    public static void processMarks(String[] subjects, Map<String, int[]> studentData) {
        for (Map.Entry<String, int[]> entry : studentData.entrySet()) {
            String name = entry.getKey();
            int[] marks = entry.getValue();
            int total = 0;
            for (int m : marks) total += m;
            System.out.println(name + " Totals: " + total);
        }
    }
}