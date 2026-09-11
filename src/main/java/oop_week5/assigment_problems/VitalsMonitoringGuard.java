package main.java.oop_week5.assigment_problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VitalsMonitoringGuard {
    private List<Double> readings;

    public VitalsMonitoringGuard(double[] initialReadings) {
        readings = new ArrayList<>();
        for (double r : initialReadings) {
            recordReading(r);
        }
    }

    public void recordReading(double reading) {
        if (reading > 0 && reading <= 45.0) {
            readings.add(reading);
        }
    }

    public double getAverage() {
        if (readings.isEmpty()) return 0.0;
        double sum = 0;
        for (double r : readings) sum += r;
        return sum / readings.size();
    }

    public double[] getAllReadings() {
        double[] copy = new double[readings.size()];
        for (int i = 0; i < readings.size(); i++) {
            copy[i] = readings.get(i);
        }
        return copy;
    }

    public static void main(String[] args) {
        VitalsMonitoringGuard v = new VitalsMonitoringGuard(new double[]{36.5, -2, 37.1});
        System.out.println(Arrays.toString(v.getAllReadings()));
    }
}