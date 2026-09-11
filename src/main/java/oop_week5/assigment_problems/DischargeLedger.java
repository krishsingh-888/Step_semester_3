package main.java.oop_week5.assigment_problems;

final class DischargeSummary {
    private final String patientId;
    private final String[] medicationCodes;

    public DischargeSummary(String patientId, String[] medicationCodes) {
        for (String code : medicationCodes) {
            if (code == null || !code.matches("MED-[A-Z]")) {
                throw new IllegalArgumentException("construction rejected");
            }
        }
        this.patientId = patientId;
        this.medicationCodes = medicationCodes.clone();
    }

    public String[] getMedicationCodes() {
        return medicationCodes.clone();
    }

    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        if (newCode == null || !newCode.matches("MED-[A-Z]")) {
            throw new IllegalArgumentException("invalid code");
        }
        String[] newCodes = medicationCodes.clone();
        newCodes[index] = newCode;
        return new DischargeSummary(this.patientId, newCodes);
    }
}

final class CriticalCareDischargeSummary extends DischargeSummary {
    private final int icuDays;

    public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
        super(patientId, medicationCodes);
        this.icuDays = icuDays;
    }

    public int getIcuDays() {
        return icuDays;
    }
}

public class DischargeLedger {
    public static String processNightlyBatch(DischargeSummary[] summaries) {
        int processed = 0, nullSkipped = 0, critical = 0, routine = 0;
        for (DischargeSummary s : summaries) {
            if (s == null) {
                nullSkipped++;
                continue;
            }
            if (s instanceof CriticalCareDischargeSummary) {
                critical++;
            } else {
                routine++;
            }
            processed++;
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + critical + " critical-care | " + routine + " routine";
    }

    public static void main(String[] args) {
        DischargeSummary[] batch = {
            new CriticalCareDischargeSummary("MT001", new String[]{"MED-X"}, 4),
            null,
            new DischargeSummary("MT002", new String[]{"MED-Y"})
        };
        System.out.println(processNightlyBatch(batch));
    }
}