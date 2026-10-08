package main.java.oop_week7.class_problems;

interface Alertable {
    String sendAlert(String message);
}

class SecuritySensor {
    private String zoneName;
    public SecuritySensor(String zoneName) { this.zoneName = zoneName; }
    public String getZoneName() { return zoneName; }
}

class MotionSensor extends SecuritySensor implements Alertable {
    public MotionSensor(String zoneName) { 
        super(zoneName); 
    }
    
    @Override
    public String sendAlert(String message) {
        return "[" + getZoneName() + "] " + message;
    }
}

class DualZoneMotionSensor extends MotionSensor {
    private String secondZoneName;
    
    public DualZoneMotionSensor(String zoneName, String secondZoneName) {
        super(zoneName);
        this.secondZoneName = secondZoneName;
    }
    
    @Override
    public String sendAlert(String message) {
        return super.sendAlert(message) + " [also covering " + secondZoneName + "]";
    }
}

class SmokeDetector implements Alertable {
    private String deviceId;
    
    public SmokeDetector(String deviceId) { this.deviceId = deviceId; }
    
    @Override
    public String sendAlert(String message) {
        return "[" + deviceId + "] " + message;
    }
}

public class HomeSafetyAlertNetwork {
    public static void broadcastAll(Alertable[] devices, String message) {
        for (Alertable d : devices) {
            if (d != null) {
                System.out.println(d.sendAlert(message));
            }
        }
    }
    
    public static String getZoneIfMotionSensor(Alertable a) {
        if (a instanceof MotionSensor) {
            return ((MotionSensor) a).getZoneName();
        }
        return "Not a motion sensor";
    }
}