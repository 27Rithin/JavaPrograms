class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

class SLL {
    Node head;

    void insertBeg(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    void insertEnd(int d) {
        Node n = new Node(d);
        if (head == null) head = n;
        else {
            Node t = head;
            while (t.next != null) t = t.next;
            t.next = n;
        }
    }

    void delBeg() {
        if (head != null) head = head.next;
    }

    void delEnd() {
        if (head == null) return;
        if (head.next == null) head = null;
        else {
            Node t = head;
            while (t.next.next != null) t = t.next;
            t.next = null;
        }
    }

    void display() {
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
        l.display(); // 5 10 20
        l.delBeg();
        l.display(); // 10 20
        l.delEnd();
        l.display(); // 10
    }
}
