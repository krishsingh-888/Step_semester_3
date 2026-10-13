package main.java.oop_week8.class_problems;

abstract class Vehicle {
    private String vehicleId;
    private boolean isAvailable = true;

    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public abstract double calculateRentalFee(int days);

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}

class StandardCar extends Vehicle {
    public StandardCar(String id) { super(id); }
    @Override
    public double calculateRentalFee(int days) { return days * 50.0; }
}

class LuxuryCar extends Vehicle {
    public LuxuryCar(String id) { super(id); }
    @Override
    public double calculateRentalFee(int days) { return days * 100.0; }
}

class SUV extends Vehicle {
    public SUV(String id) { super(id); }
    @Override
    public double calculateRentalFee(int days) { return days * 80.0; }
}

class RentalService {
    public double rentVehicle(Vehicle v, int days) {
        if (!v.isAvailable()) {
            throw new IllegalStateException("Vehicle cannot be rented; already active rental.");
        }
        v.setAvailable(false);
        return v.calculateRentalFee(days);
    }

    public void returnVehicle(Vehicle v) {
        v.setAvailable(true);
    }
}

public class VehicleRentalSystem {
    // Vehicle Rental System with Dynamic Pricing container
}