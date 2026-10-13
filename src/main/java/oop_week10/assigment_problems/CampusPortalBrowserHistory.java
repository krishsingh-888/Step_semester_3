package main.java.oop_week10.assigment_problems;

class DNode {
    String url;
    DNode prev, next;
    public DNode(String url) { this.url = url; }
}

class BrowserHistory {
    private DNode current;

    public BrowserHistory(String homepage) {
        current = new DNode(homepage);
    }

    public void visit(String url) {
        DNode newNode = new DNode(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }
}

public class CampusPortalBrowserHistory {
    // Container implementation
}