package main.java.oop_week10.class_problems;

import java.util.HashMap;
import java.util.Map;

public class SmartHomePlatform {
    public static class SmartDevice {
        private String id;
        private boolean isOn = false;
        private int brightness = 0;
        private String schedule = "";
        private int energy = 0;
        private Map<String, Boolean> capabilities;

        public SmartDevice(String id, boolean dim, boolean sched, boolean eng) {
            this.id = id;
            capabilities = new HashMap<>();
            capabilities.put("dim", dim);
            capabilities.put("schedule", sched);
            capabilities.put("energy", eng);
        }

        public String executeCommand(String cmd) {
            String[] parts = cmd.split(" ");
            String action = parts[0];
            if (action.equals("ON")) {
                isOn = true;
                return id + " is ON";
            } else if (action.equals("DIM")) {
                if (!capabilities.get("dim")) return id + " rejected: DIM unsupported";
                brightness = Integer.parseInt(parts[2]);
                return id + " dimmed to " + brightness;
            } else if (action.equals("SCHEDULE")) {
                if (!capabilities.get("schedule")) return id + " rejected: SCHEDULE unsupported";
                schedule = parts[2];
                return id + " scheduled " + schedule;
            } else if (action.equals("ENERGY")) {
                if (!capabilities.get("energy")) return id + " rejected: ENERGY unsupported";
                return id + " energy 12 kWh";
            }
            return "Unknown command";
        }
    }
}