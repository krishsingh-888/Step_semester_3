package oop_week3.class_problems;

public class SrmStudent {
    String name;
    String regNo;
    int attendance;

    public SrmStudent(String name, String regNo, int attendance) {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;
    }

    public void addAttendanceUpdate(int newAttendance) {
        this.attendance = newAttendance;
    }

    public boolean isEligible() {
        return this.attendance >= 75;
    }

    // Static because it operates on the collective group, not a single instance
    public static double classAverage(SrmStudent[] students) {
        double total = 0;
        for (SrmStudent s : students) {
            total += s.attendance;
        }
        return total / students.length;
    }

    public static void main(String[] args) {
        SrmStudent[] students = {
            new SrmStudent("Ravi", "101", 82),
            new SrmStudent("Anitha", "102", 68),
            new SrmStudent("Karthik", "103", 91),
            new SrmStudent("Meera", "104", 74),
            new SrmStudent("Suresh", "105", 60)
        };

        for (SrmStudent s : students) {
            System.out.println(s.name + " " + s.attendance + "% " + 
                              (s.isEligible() ? "Eligible" : "Detained"));
        }
        System.out.println("Class average: " + SrmStudent.classAverage(students) + "%");
    }
}