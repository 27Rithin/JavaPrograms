import java.util.*;

class Cocomo 
{
  public static void main(String[] args) {
    
        Scanner obj = new Scanner(System.in);

        int s, r, comp;

        int cw1, cw2, cw3;

        int prod;

        float NOP, EE;

        System.out.println("Enter no.of Screens:");
        s = obj.nextInt();

        System.out.println("Enter Complexity weight of Screens:");
        cw1 = obj.nextInt();

        System.out.println("Enter no.of Reports:");
        r = obj.nextInt();

        System.out.println("Enter Complexity weight of Reports:");
        cw2 = obj.nextInt();

        System.out.println("Enter no.of Components:");
        comp = obj.nextInt();

        System.out.println("Enter Complexity weight of Components:");
        cw3 = obj.nextInt();

        System.out.println("Enter Value of Productivity:");
        prod = obj.nextInt();

        NOP = (s * cw1) + (r * cw2) + (comp * cw3);
        System.out.println("NOP = " + NOP);

        EE = NOP / prod;
        System.out.println("Estimated Effort using COCOMO 2 model = " + EE);



  }
}