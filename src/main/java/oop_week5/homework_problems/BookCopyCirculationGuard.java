package main.java.oop_week5.assigment_problems;

public class BookCopyCirculationGuard {
    private int copiesTotal;
    private int copiesAvailable;

    public BookCopyCirculationGuard(int copiesTotal) {
        if (copiesTotal <= 0) throw new IllegalArgumentException("construction rejected");
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (copiesAvailable > 0) copiesAvailable--;
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) copiesAvailable++;
    }

    public int getCopiesAvailable() { 
        return copiesAvailable; 
    }
}