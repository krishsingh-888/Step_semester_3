package main.java.oop_week9.class_problems;

public class LibraryCatalogLookup {
    public static class BookRecord {
        public String isbn;
        public String title;

        public BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(BookRecord[] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog[mid].title;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "Not Found";
    }
}