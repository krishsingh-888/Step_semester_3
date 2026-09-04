package main.java.oop_week2.class_problems;

public class CSVParser {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + fields[0].trim() + " | Roll No: " + fields[1].trim() + " | Dept: " + fields[2].trim());
    }
    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}