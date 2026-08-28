package oop_week3.class_problems;

public class HostelRoom {
    String roomNo;
    int beds;
    int occupied;

    public void allot(String studentName) {
        if (occupied < beds) {
            occupied++;
            System.out.println(studentName + " allotted to room " + roomNo);
        } else {
            System.out.println("Waiting-list: Room " + roomNo + " is already full.");
        }
    }

    public static void main(String[] args) {
        HostelRoom room214 = new HostelRoom();
        room214.roomNo = "C-214";
        room214.beds = 2;
        room214.occupied = 0;

        HostelRoom sameRoom = room214;
        sameRoom.allot("Ravi");
        System.out.println("room214 occupied (seen via first variable): " + room214.occupied);
        System.out.println("sameRoom == room214: " + (sameRoom == room214));

        HostelRoom separate = new HostelRoom();
        separate.roomNo = "C-214";
        separate.beds = 2;
        separate.occupied = 1; // matches post-allotment state
        System.out.println("separate == room214: " + (separate == room214));

        sameRoom.allot("Anitha");
        sameRoom.allot("Karthik"); // Triggers waiting list message
    }
}