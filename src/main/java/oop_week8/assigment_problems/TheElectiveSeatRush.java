package main.java.oop_week8.assigment_problems;

import java.util.LinkedList;
import java.util.Queue;

class Elective {
    private String electiveName;
    private int capacity;
    private int creditValue;
    private Queue<Student> waitlist = new LinkedList<>();

    public Elective(String electiveName, int capacity, int creditValue) {
        this.electiveName = electiveName;
        this.capacity = capacity;
        this.creditValue = creditValue;
    }

    public void addToWaitlist(Student s) {
        waitlist.add(s);
    }

    public Student promoteNext() {
        return waitlist.poll();
    }
}

class Student {
    private String studentName;
    private int currentCredits;

    public Student(String studentName, int currentCredits) {
        this.studentName = studentName;
        this.currentCredits = currentCredits;
    }
    public int getCurrentCredits() { return currentCredits; }
}

public class TheElectiveSeatRush {
    // Elective Seat Rush & Waitlist Management container
}