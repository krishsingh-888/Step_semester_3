package oop_week3.class_problems;

public class CapstoneSystem {
    String name;
    String regNo;
    FeeAccount feeAccount;
    HostelRoom room;
    
    static int totalStudents = 0;

    public CapstoneSystem(String name, String regNo, FeeAccount feeAccount, HostelRoom room) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = room;
        totalStudents++;
    }

    public String fullStatus() {
        // Pulls data straight from the composed objects
        return this.name + " | Due: Rs " + this.feeAccount.getDue() + 
               " | Room: " + this.room.roomNo;
    }

    public static void main(String[] args) {
        // Setup shared rooms
        HostelRoom room214 = new HostelRoom(); room214.roomNo = "C-214"; room214.beds = 2;
        HostelRoom room507 = new HostelRoom(); room507.roomNo = "C-507"; room507.beds = 2;
        HostelRoom room309 = new HostelRoom(); room309.roomNo = "C-309"; room309.beds = 2;

        System.out.println("3 students, each with a FeeAccount and a HostelRoom:");
        
        CapstoneSystem ravi = new CapstoneSystem("Ravi", "101", new FeeAccount("101", 200000), room214);
        CapstoneSystem anitha = new CapstoneSystem("Anitha", "102", new FeeAccount("102", 180000), room507);
        CapstoneSystem karthik = new CapstoneSystem("Karthik", "103", new FeeAccount("103", 180000), room309);

        // Process a couple of payments
        ravi.feeAccount.payInTwoInstallments(120000);
        karthik.feeAccount.pay(36000);

        System.out.println(ravi.fullStatus());
        System.out.println(anitha.fullStatus());
        System.out.println(karthik.fullStatus());

        System.out.println("Total students: " + CapstoneSystem.totalStudents);
    }
}