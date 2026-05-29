import java.util.Scanner;

public class BinarySubtraction {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter first binary number:");
        String first = scnr.nextLine();

        System.out.println("Enter second binary number:");
        String second = scnr.nextLine();

        String difference = subtract(first, second);

        System.out.println("Difference: " + difference);

        scnr.close();
    }

    public static String subtract(String first, String second) {
        int b1 = Integer.parseInt(first, 2);
        int b2 = Integer.parseInt(second, 2);
        int diff = b1 - b2;
        return Integer.toBinaryString(diff);
    }
}
