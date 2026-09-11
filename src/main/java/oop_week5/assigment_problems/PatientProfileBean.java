package main.java.oop_week5.assigment_problems;

public class PatientProfileBean {
    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPin;

    public PatientProfileBean() {
        this(null, null);
    }

    public PatientProfileBean(String name) {
        this(null, name);
    }

    public PatientProfileBean(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.discharged = false;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (this.patientId == null && patientId != null && !patientId.trim().isEmpty()) {
            this.patientId = patientId;
        }
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public void setLockerPin(String pin) {
        this.lockerPin = pin;
    }

    public static void main(String[] args) {
        PatientProfileBean p = new PatientProfileBean();
        p.setPatientId("MT2026-0142");
        p.setPatientId("HACKED-0000");
        System.out.println(p.getPatientId());
    }
}