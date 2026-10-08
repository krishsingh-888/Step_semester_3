package main.java.oop_week7.assigment_problems;

interface Exportable {
    String exportData();
}

class ReportGenerator implements Exportable {
    private String reportName;
    public ReportGenerator(String reportName) { this.reportName = reportName; }
    
    @Override
    public String exportData() {
        OneClickDataExport.incrementExports();
        return "Exported report: " + reportName;
    }
}

class UserProfile implements Exportable {
    private String username;
    public UserProfile(String username) { this.username = username; }
    
    @Override
    public String exportData() {
        OneClickDataExport.incrementExports();
        return "Exported profile: " + username;
    }
}

public class OneClickDataExport {
    private static int totalExports = 0;
    
    public static void incrementExports() { totalExports++; }
    public static int getTotalExports() { return totalExports; }
    
    public static void exportAll(Exportable[] items) {
        for (Exportable item : items) {
            if (item != null) System.out.println(item.exportData());
        }
    }
}