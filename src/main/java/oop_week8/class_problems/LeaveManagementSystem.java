package main.java.oop_week8.class_problems;

enum LeaveStatus { PENDING, APPROVED, REJECTED }

class LeaveRequest {
    private String employeeName;
    private LeaveStatus status = LeaveStatus.PENDING;

    public LeaveRequest(String employeeName) {
        this.employeeName = employeeName;
    }

    public void approve() {
        if (this.status == LeaveStatus.PENDING) {
            this.status = LeaveStatus.APPROVED;
        } else {
            throw new IllegalStateException("Cannot change status once approved or rejected.");
        }
    }

    public void reject() {
        if (this.status == LeaveStatus.PENDING) {
            this.status = LeaveStatus.REJECTED;
        } else {
            throw new IllegalStateException("Cannot change status once approved or rejected.");
        }
    }

    public LeaveStatus getStatus() { return status; }
}

public class LeaveManagementSystem {
    // Employee Leave Request Management container
}