package main.java.oop_week7.assigment_problems;

abstract class HomeDevice {
    private static int counter = 1001;
    private final String serialNumber;
    
    public HomeDevice() {
        this.serialNumber = "HD-" + (counter++);
    }
    
    public abstract String activate();
    public String getSerialNumber() { return serialNumber; }
}

interface RemoteControllable {
    String connect(String appId);
}

interface EnergyTrackable {
    double getConsumptionWatts();
}

class WashingMachine extends HomeDevice implements RemoteControllable, EnergyTrackable {
    private double consumptionWatts;
    public WashingMachine(double consumptionWatts) { this.consumptionWatts = consumptionWatts; }
    
    @Override
    public String activate() { return "Washing machine " + getSerialNumber() + " started a cycle"; }
    
    @Override
    public String connect(String appId) { return getSerialNumber() + " connected to " + appId; }
    
    @Override
    public double getConsumptionWatts() { return consumptionWatts; }
}

class Refrigerator extends HomeDevice implements EnergyTrackable {
    private double consumptionWatts;
    public Refrigerator(double consumptionWatts) { this.consumptionWatts = consumptionWatts; }
    
    @Override
    public String activate() { return "Refrigerator " + getSerialNumber() + " cooling activated"; }
    
    @Override
    public double getConsumptionWatts() { return consumptionWatts; }
}

class MobileApp implements RemoteControllable {
    private String appName;
    public MobileApp(String appName) { this.appName = appName; }
    
    @Override
    public String connect(String appId) { return appName + " App connected to " + appId; }
}

public class ConnectedHomeControlPanel {
    public static void connectAll(RemoteControllable[] items, String appId) {
        for (RemoteControllable rc : items) {
            if (rc != null) System.out.println(rc.connect(appId));
        }
    }
    
    public static double getConsumptionIfTrackable(HomeDevice d) {
        if (d instanceof EnergyTrackable) {
            return ((EnergyTrackable) d).getConsumptionWatts();
        }
        return 0.0;
    }
}