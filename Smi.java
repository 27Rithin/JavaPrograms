import java.util.Scanner;

public class Smi {
    
   public static void main(String[] args) {
    
         Scanner obj = new Scanner(System.in);

         int MT, FA, FC, FD;
         float SMI;

         System.out.println("Enter MT:");
         MT = obj.nextInt();

         System.out.println("Enter FA:");
         FA = obj.nextInt();

         System.out.println("Enter FC:");
         FC = obj.nextInt();

         System.out.println("Enter FD:");
         FD = obj.nextInt();

         SMI = (float) (MT - (float)(FA * FC + FD) / MT);

         System.out.println("The resultant SMI is:" + SMI);

   }

}
