package main.java.oop_week3.assigment_problems;

class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;
    
    // COMMENT: Marking name, memberId, and booksIssued as static means they belong to the class level. 
    // Creating or modifying any member silently overwrites the data globally for every member.
}

class FixedLibraryMember {
    String name;
    String memberId;
    int booksIssued;
    
    static String libraryName = "City Central Library";
    static int memberCount = 0;

    public FixedLibraryMember(String name) {
        this.name = name;
        this.booksIssued = 0;
        memberCount++;
        this.memberId = "LM-" + (1000 + memberCount);
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}

public class LibraryMembership {
    public static void main(String[] args) {
        System.out.println("--- Broken Version ---");
        BrokenLibraryMember.name = "Aditi";
        BrokenLibraryMember.name = "Rohan";
        System.out.println(BrokenLibraryMember.name);
        System.out.println("(Aditi's data was overwritten - both members now show 'Rohan')\n");

        System.out.println("--- Fixed Version ---");
        FixedLibraryMember m1 = new FixedLibraryMember("Aditi");
        FixedLibraryMember m2 = new FixedLibraryMember("Rohan");
        
        m1.printMemberCard();
        m2.printMemberCard();
        FixedLibraryMember.printTotalMembers();
    }
}