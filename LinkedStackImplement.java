import java.util.*;

class Node {
    int data;
    Node link;

    Node(int d, Node n) {
        data = d; link = n;
    }
}

class LinkedStack {
    Node top;
    int size;

    LinkedStack() {
        top = null; size = 0;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(int data) {
        top = new Node(data, top); size++;
    }

    int pop() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        int val = top.data; top = top.link; size--;
        return val;
    }

    int peek() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return top.data;
    }
}

public class LinkedStackImplement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedStack ls = new LinkedStack();
        char ch;

        do {
            System.out.println("\n1. Push\n2. Pop\n3. Peek\nEnter choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: System.out.print("Enter element to push: "); ls.push(scan.nextInt()); break;
                case 2: 
                    try { System.out.println("Popped = " + ls.pop()); } 
                    catch (Exception e) { System.out.println("Error: " + e.getMessage()); } break;
                case 3: 
                    try { System.out.println("Top = " + ls.peek()); } 
                    catch (Exception e) { System.out.println("Error: " + e.getMessage()); } break;
                default: System.out.println("Wrong Entry");
            }

            System.out.print("Continue? (y/n): ");
            ch = scan.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
    }
} 