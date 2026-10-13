package main.java.oop_week8.assigment_problems;

import java.util.HashMap;
import java.util.Map;

interface Capability {}
interface PowerCapability extends Capability { void setPower(boolean on); boolean getPower(); }
interface BrightnessCapability extends Capability { void setBrightness(int level); int getBrightness(); }
interface TemperatureCapability extends Capability { void setTemperature(double temp); double getTemperature(); }

class SmartDevice {
    private String deviceId;
    private Map<Class<?>, Capability> capabilities = new HashMap<>();

    public SmartDevice(String deviceId) { this.deviceId = deviceId; }

    public void addCapability(Class<?> capInterface, Capability capability) {
        capabilities.put(capInterface, capability);
    }

    @SuppressWarnings("unchecked")
    public <T extends Capability> T getCapability(Class<T> capInterface) {
        return (T) capabilities.get(capInterface);
    }
}

class Scene {
    private String sceneName;
    public Scene(String sceneName) { this.sceneName = sceneName; }
    
    public void executeScene(SmartDevice device) {
        // Runtime capability validation and execution
    }
}

public class SmartLabControlPanel {
    // Smart Lab Control Panel container
}