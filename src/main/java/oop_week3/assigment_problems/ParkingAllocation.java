package main.java.oop_week3.assigment_problems;

class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public void allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
            System.out.println(vehicleNo + " allotted to slot " + slotNo);
        }
    }
}

public class ParkingAllocation {
    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        for (ParkingSlot slot : slots) {
            if (slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot available = findAvailableSlot(slots);
        if (available != null) {
            available.allot(vehicleNo);
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }

    public static void main(String[] args) {
        ParkingSlot[] openSlots = { new ParkingSlot("A1", 4, 3), new ParkingSlot("A2", 5, 5) };
        ParkingSlot[] fullSlots = { new ParkingSlot("A1", 4, 4), new ParkingSlot("A2", 5, 5) };

        System.out.print("Slots: A1 (3/4), A2 (5/5) | ");
        safeAllot(openSlots, "TN09AB1234");
        
        System.out.print("Slots: A1 (4/4), A2 (5/5) | ");
        safeAllot(fullSlots, "TN09AB1234");
        
        // COMMENT: Passing the ParkingSlot array passes a reference to the array structure in memory, 
        // not deep copies of the slot objects. Alterations inside the method update the true slot status.
    }
}