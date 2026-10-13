package main.java.oop_week10.assigment_problems;

class Node {
    int data;
    Node next;
    public Node(int data) { this.data = data; }
}

public class CancellingKthLastOrder {
    public static Node removeKthFromEnd(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i <= k; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}