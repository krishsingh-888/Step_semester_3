package main.java.oop_week7.class_problems;

abstract class StaffMember {
    private double baseSalary;
    protected double bonusRate;

    public StaffMember(double baseSalary) {
        this(baseSalary, 0.10);
    }

    public StaffMember(double baseSalary, double bonusRate) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("rejected, salary unchanged");
        }
        this.bonusRate = bonusRate;
    }

    public abstract double calculateBonus();

    public double getSalary() { return baseSalary; }
    
    public void setSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("rejected, salary unchanged");
        }
    }
}

interface Auditable {
    String auditRecord();
}

class TeamLead extends StaffMember implements Auditable {
    private int teamSize;

    public TeamLead(double baseSalary, int teamSize) {
        super(baseSalary);
        this.teamSize = teamSize;
    }

    public TeamLead(double baseSalary, double bonusRate, int teamSize) {
        super(baseSalary, bonusRate);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * bonusRate;
    }

    @Override
    public String auditRecord() {
        return "TeamLead audit: " + teamSize + " team members, salary $" + getSalary();
    }
}

public class QuarterlyBonusCalculator {
    public static String getAuditIfApplicable(StaffMember s) {
        if (s instanceof Auditable) {
            return ((Auditable) s).auditRecord();
        }
        return "No audit required";
    }
}