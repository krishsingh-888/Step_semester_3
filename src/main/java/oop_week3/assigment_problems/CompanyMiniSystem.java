package main.java.oop_week3.assigment_problems;

class CompanyEmployeeRecord {
    String name;
    String empId;
    Employee employee; 
    ParkingSlot slot;  

    static int totalRecords = 0;

    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    public void fullProfile() {
        double pay = employee.getSalary();
        if (employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        }
        
        String parking = (slot != null) ? slot.slotNo : "no parking assigned";
        System.out.println("Name: " + name + " | Pay: Rs " + pay + " | Slot: " + parking);
    }
}

public class CompanyMiniSystem {
    public static void main(String[] args) {
        Employee emp1 = new Employee("E101", "Alice", 50000);
        ManagerEmployee emp2 = new ManagerEmployee("M201", "Bob", 80000, 10000);
        Employee emp3 = new Employee("E102", "Charlie", 45000);

        ParkingSlot p1 = new ParkingSlot("P-10", 1, 1);
        ParkingSlot p2 = new ParkingSlot("P-11", 1, 1);

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Alice", "E101", emp1, p1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Bob", "M201", emp2, p2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Charlie", "E102", emp3, null); 

        r1.fullProfile();
        r2.fullProfile();
        r3.fullProfile();
        
        System.out.println("Total Company Records: " + CompanyEmployeeRecord.totalRecords);
    }
}