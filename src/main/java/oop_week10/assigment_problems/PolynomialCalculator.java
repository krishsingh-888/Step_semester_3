package main.java.oop_week10.assigment_problems;

class PolyNode {
    int coeff, exp;
    PolyNode next;
    public PolyNode(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
    }
}

public class PolynomialCalculator {
    public static PolyNode addPolynomials(PolyNode p, PolyNode q) {
        PolyNode dummy = new PolyNode(0, 0);
        PolyNode tail = dummy;

        while (p != null && q != null) {
            if (p.exp > q.exp) {
                tail.next = new PolyNode(p.coeff, p.exp);
                p = p.next;
            } else if (p.exp < q.exp) {
                tail.next = new PolyNode(q.coeff, q.exp);
                q = q.next;
            } else {
                int sumCoeff = p.coeff + q.coeff;
                if (sumCoeff != 0) {
                    tail.next = new PolyNode(sumCoeff, p.exp);
                    tail = tail.next;
                }
                p = p.next;
                q = q.next;
                continue;
            }
            tail = tail.next;
        }

        while (p != null) {
            tail.next = new PolyNode(p.coeff, p.exp);
            p = p.next;
            tail = tail.next;
        }

        while (q != null) {
            tail.next = new PolyNode(q.coeff, q.exp);
            q = q.next;
            tail = tail.next;
        }

        return dummy.next;
    }
}