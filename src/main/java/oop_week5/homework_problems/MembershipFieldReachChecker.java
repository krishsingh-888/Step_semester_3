package main.java.oop_week5.assigment_problems;

class LibraryMember {
    private String membershipId;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
        if (membershipId == null || membershipId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.membershipId = membershipId;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}

public class MembershipFieldReachChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private": return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default": return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected": return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED"; 
            case "public": return "ALLOWED";
            default: return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        int privA = 0, privD = 0, defA = 0, defD = 0, protA = 0, protD = 0, pubA = 0, pubD = 0;
        for (String[] a : attempts) {
            String res = classifyAccess(a[0], a[1]);
            if (a[0].equals("private")) { if(res.equals("ALLOWED")) privA++; else privD++; }
            else if (a[0].equals("default")) { if(res.equals("ALLOWED")) defA++; else defD++; }
            else if (a[0].equals("protected")) { if(res.equals("ALLOWED")) protA++; else protD++; }
            else if (a[0].equals("public")) { if(res.equals("ALLOWED")) pubA++; else pubD++; }
        }
        return "private: " + privA + " allowed / " + privD + " denied | default: " + defA + " allowed / " + defD + " denied | protected: " + protA + " allowed / " + protD + " denied | public: " + pubA + " allowed / " + pubD + " denied";
    }
}