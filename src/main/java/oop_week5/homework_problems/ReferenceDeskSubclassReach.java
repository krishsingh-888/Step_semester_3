package main.java.oop_week5.assigment_problems;

public class ReferenceDeskSubclassReach {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE") || 
                accessorContext.equals("SAME_CLASS") || 
                accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        return "DENIED"; 
    }

    public static String describeContext(String accessorContext) {
        String[] parts = accessorContext.toLowerCase().split("_");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                sb.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }
}