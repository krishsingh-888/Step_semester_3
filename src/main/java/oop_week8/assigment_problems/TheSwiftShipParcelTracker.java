package main.java.oop_week8.assigment_problems;

enum ParcelStatus { BOOKED, PICKED_UP, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED }

interface NotificationService {
    void notifyUser(String message);
}

class SmsChannel implements NotificationService {
    @Override
    public void notifyUser(String message) { /* SMS Notification Logic */ }
}

class EmailChannel implements NotificationService {
    @Override
    public void notifyUser(String message) { /* Email Notification Logic */ }
}

class Parcel {
    private String trackingId;
    private double weightKg;
    private ParcelStatus status = ParcelStatus.BOOKED;
    private List<NotificationService> channels = new ArrayList<>();

    public Parcel(String trackingId, double weightKg) {
        this.trackingId = trackingId;
        this.weightKg = weightKg;
    }

    public void addChannel(NotificationService channel) {
        channels.add(channel);
    }

    public void updateStatus(ParcelStatus newStatus) {
        // Enforce valid strict forward workflow
        if (this.status == ParcelStatus.DELIVERED) {
            throw new IllegalStateException("Invalid transition: Cannot change status from DELIVERED.");
        }
        this.status = newStatus;
        notifyChannels("Parcel status updated to: " + newStatus);
    }

    private void notifyChannels(String msg) {
        for (NotificationService c : channels) c.notifyUser(msg);
    }

    public ParcelStatus getStatus() { return status; }
}

public class TheSwiftShipParcelTracker {
    // Parcel Delivery Tracking System container
}