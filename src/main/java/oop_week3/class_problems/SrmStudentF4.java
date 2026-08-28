package oop_week3.class_problems;

public class SrmStudentF4 {
    String name;
    String regNo;
    int attendance;
    
    // Shared across all objects
    static String university = "SRM Institute of Science and Technology";
    static int admissionCount = 301010; 

    public SrmStudentF4(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        admissionCount++;
        this.regNo = "RA231100" + admissionCount; // Auto-generates ID
    }

    public void printIdCard() {
        System.out.println(this.name + " | " + this.regNo + " | " + university);
    }

    public static void printTotalAdmissions() {
        // We cannot use 'this.name' here because static methods don't know which object to look at
        System.out.println("Students admitted so far: " + (admissionCount - 301010));
    }

    public static void main(String[] args) {
        System.out.println("3 SrmStudent objects created:");
        SrmStudentF4 ravi = new SrmStudentF4("Ravi", 82);
        SrmStudentF4 meera = new SrmStudentF4("Meera", 74);
        SrmStudentF4 karthik = new SrmStudentF4("Karthik", 91);

        ravi.printIdCard();
        meera.printIdCard();
        karthik.printIdCard();

        SrmStudentF4.printTotalAdmissions();
    }
}