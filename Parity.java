import java.util.*;


   public class Parity

{

   public static void main(String[] args)

{

   Scanner sc = new Scanner(System.in);

   List<String> binaryNumbers = new ArrayList<>();

   System.out.println("Enter binary numbers(one per line, press enter on empty line to finish):");

   
   while(true)
{

   String input = sc.nextLine();

   if(input.isEmpty())
{
    break;

}

   binaryNumbers.add(input);

}

   for (String binaryNumber : binaryNumbers)
{

   char[] binaryArray = binaryNumber.toC
harArray();

   int oneCount = 0;

    
   for (char bit : binaryArray)
 {

    if (bit == '1')
 {

    oneCount++;

 }

 
 }
   
   char parityBit = (oneCount % 2 == 0) ? '0' : '1';


   String N = binaryNumber + parityBit;

 
   System.out.println("Original: " + binaryNumber);

   System.out.println("With Even Parity: " + N);
    
}


   sc.close();

}


}