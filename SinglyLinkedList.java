class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class SLL {
    Node head;

    void insertBeg(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    void insertEnd(int d) {
        Node n = new Node(d);  // ✅ FIXED: removed 'int' from inside new Node()
        if (head == null) {
            head = n;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = n;  // ✅ FIXED: this line was wrongly placed inside loop
        }
    }

    void delBeg() {
        if (head != null)
            head = head.next;
    }

    void delEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        } else {
            Node t = head;
            while (t.next.next != null) {
                t = t.next;
            }
            t.next = null;
        }
    }

    void display(String msg) {
        System.out.print(msg);
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLL l = new SLL();
        l.insertBeg(10);
        l.insertEnd(20);
        l.insertBeg(5);
        l.display("After insertions: ");
        l.delBeg();
        l.display("After deleting from beginning: ");
        l.delEnd();
        l.display("After deleting from end: ");
    }
}
