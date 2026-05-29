import java.io.*;

public class Substitution
{

   public static void main(String[] args) throws IOException
   {
    
     String temp;
     int key,t;

     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
     System.out.println("Enter plain text: ");

     temp = br.readLine();

     temp = temp.toUpperCase();

     System.out.println("Enter key: ");

     key = Integer.parseInt(br.readLine());


     char plain[] = new char[temp.length()];

     char cipher[] = new char[temp.length()];

     char decipher[] = new char[temp.length()];

     for (int j = 0; j < temp.length(); j++)
     {
        plain[j] = temp.charAt(j);
     }

     for (int i = 0; i < temp.length(); i++)
     {

       t = plain[i];

       if ((t + key) % 122 <= key)
       {
 
          cipher[i] = (char) (96 + (t + key) % 122);


       }
       else
       {

          cipher[i] = (char) ((t + key) % 122);

       }


     }

 for (int i = 0; i < temp.length(); i++)
     {

       t = cipher[i];

       if ((t - key) % 122 < 97)
       {
 
          decipher[i] = (char) (122 - (96 - (t - key) % 122));


       }
       else
       {

          decipher[i] = (char) ((t - key) % 122);

       }


     }

    System.out.println("\nGiven plain text: ");
    for (int i = 0; i < temp.length(); i++)
       System.out.print(plain[i]);

      System.out.println("\n\ncipher text: ");
    for (int i = 0; i < temp.length(); i++)
       System.out.print(cipher[i]); 

    System.out.println("\n\ndecipher text: ");
    for (int i = 0; i < temp.length(); i++)
       System.out.print(decipher[i]); 

   System.out.println();

   }


}