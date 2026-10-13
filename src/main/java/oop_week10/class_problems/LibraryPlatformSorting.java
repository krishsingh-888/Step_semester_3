package main.java.oop_week10.class_problems;

import java.util.ArrayList;
import java.util.List;

public class LibraryPlatformSorting {
    public static class Resource {
        String type;
        String id;
        boolean reservable;
        boolean downloadable;

        public Resource(String type, String id, boolean reservable, boolean downloadable) {
            this.type = type;
            this.id = id;
            this.reservable = reservable;
            this.downloadable = downloadable;
        }
    }

    private List<Resource> catalog = new ArrayList<>();

    public String addResource(String type, String id, boolean res, boolean down) {
        for (Resource r : catalog) {
            if (r.id.equals(id)) return "duplicate rejected";
        }
        catalog.add(new Resource(type, id, res, down));
        return id + " added";
    }

    public String reserve(String id, String memberId) {
        for (Resource r : catalog) {
            if (r.id.equals(id)) {
                if (!r.reservable) return id + " rejected: reservation unsupported";
                return id + " reserved for " + memberId;
            }
        }
        return "Resource not found";
    }

    public String download(String id) {
        for (Resource r : catalog) {
            if (r.id.equals(id)) {
                if (!r.downloadable) return id + " rejected: download unsupported";
                return id + " downloaded";
            }
        }
        return "Resource not found";
    }

    public int findIndex(String id) {
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).id.equals(id)) return i;
        }
        return -1;
    }
}