package main.java.oop_week5.assigment_problems;

public class LibraryMemberBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberBean() { 
        this(null, null); 
    }

    public LibraryMemberBean(String name) { 
        this(null, name); 
    }

    public LibraryMemberBean(String membershipId, String name) {
        this.membershipId = membershipId;
        this.name = name;
    }

    public String getMembershipId() { 
        return membershipId; 
    }

    public void setMembershipId(String id) {
        if (this.membershipId == null && id != null && !id.trim().isEmpty()) {
            this.membershipId = id;
        }
    }

    public boolean isPremiumMember() { 
        return premiumMember; 
    }

    public void setPremiumMember(boolean premium) { 
        this.premiumMember = premium; 
    }

    public void setSecurityAnswer(String answer) { 
        this.securityAnswer = answer; 
    }
}