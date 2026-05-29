import java.util.*;

class Array {
    int[] a = new int[60];
    int n = 0;
    Scanner sc = new Scanner(System.in);

    void create() {
        System.out.print("Enter size of array: ");
        n = sc.nextInt();
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
    }

    void display() {
        System.out.println("Array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    void insert() {
        System.out.print("Enter position to insert (0-based index): ");
        int pos = sc.nextInt();
        System.out.print("Enter value to insert: ");
        int val = sc.nextInt();
        for (int i = n; i > pos; i--) {
            a[i] = a[i - 1];
        }
        a[pos] = val;
        n++;
    }

    void delete() {
        System.out.print("Enter position to delete (0-based index): ");
        int pos = sc.nextInt();
        for (int i = pos; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        n--;
    }

    void sort() {
        Arrays.sort(a, 0, n);
        System.out.println("Array sorted.");
    }

    void merge() {
        System.out.print("Enter size of second array: ");
        int n1 = sc.nextInt();
        int[] b = new int[n1];
        System.out.println("Enter values for second array:");
        for (int i = 0; i < n1; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 0; i < n1; i++) {
            a[n + i] = b[i];
        }
        n += n1;

        System.out.println("Arrays merged.");
    }

    void search() {
        System.out.print("Enter element to search: ");
        int x = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                System.out.println("Element found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found.");
        }
    }
}

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array ar = new Array();
        int choice;

        do {
            System.out.println("\n**** MAIN MENU ****");
            System.out.println("1. Create");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Sort");
            System.out.println("5. Merge");
            System.out.println("6. Search");
            System.out.println("7. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: ar.create(); break;
                case 2: ar.insert(); break;
                case 3: ar.delete(); break;
                case 4: ar.sort(); break;
                case 5: ar.merge(); break;
                case 6: ar.search(); break;
                case 7: ar.display(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
