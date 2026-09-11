package main.java.oop_week5.assigment_problems;

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    static final double LATE_FEE_RATE; 

    static {
        LATE_FEE_RATE = 2.50; 
    }

    public LoanReceipt(String memberId, String[] bookIds) {
        for (String id : bookIds) {
            if (id == null || !id.matches("BK-\\d{3}")) {
                throw new IllegalArgumentException("construction rejected");
            }
        }
        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    public String[] getBookIds() { 
        return bookIds.clone(); 
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (newId == null || !newId.matches("BK-\\d{3}")) {
            throw new IllegalArgumentException("invalid format");
        }
        String[] newBookIds = bookIds.clone();
        newBookIds[index] = newId;
        return new LoanReceipt(this.memberId, newBookIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}

public class NightlyCirculationLedger {
    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, ref = 0, reg = 0;
        
        for (LoanReceipt r : receipts) {
            if (r == null) { 
                nullSkipped++; 
                continue; 
            }
            if (r instanceof ReferenceOnlyLoanReceipt) {
                ref++;
            } else {
                reg++;
            }
            processed++;
        }
        
        return processed + " processed | " + nullSkipped + " null skipped | " + ref + " reference-only | " + reg + " regular";
    }
}