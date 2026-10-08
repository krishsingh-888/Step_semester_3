package main.java.oop_week7.class_problems;

abstract class LibraryItem {
    private static int counter = 1;
    private final String itemId;
    
    public LibraryItem() {
        this.itemId = "ITEM-" + (counter++);
    }
    
    public abstract int getLoanPeriodDays();
    public String getItemId() { return itemId; }
}

interface Renewable { String renew(); }
interface Reservable { String reserve(); }

class Textbook extends LibraryItem implements Renewable, Reservable {
    private String title;
    public Textbook(String title) { this.title = title; }
    
    @Override
    public int getLoanPeriodDays() { return 14; }
    
    @Override
    public String renew() { return "Textbook renewed"; }
    
    @Override
    public String reserve() { return "Textbook reserved"; }
}

class Magazine extends LibraryItem implements Renewable {
    private String title;
    public Magazine(String title) { this.title = title; }
    
    @Override
    public int getLoanPeriodDays() { return 7; }
    
    @Override
    public String renew() { return "Magazine renewed"; }
}

class DigitalPass implements Renewable {
    private String resourceName;
    public DigitalPass(String resourceName) { this.resourceName = resourceName; }
    
    @Override
    public String renew() { return "Digital pass renewed"; }
}

public class CommunityLibraryCheckoutSystem {
    public static void processCheckouts(LibraryItem[] items) {
        for (LibraryItem item : items) {
            if (item != null) {
                System.out.println("Loan period: " + item.getLoanPeriodDays() + " days");
            }
        }
    }
    
    public static String checkReservation(Object obj) {
        if (obj instanceof Reservable) {
            return ((Reservable) obj).reserve();
        }
        return "Reservation not supported";
    }
}