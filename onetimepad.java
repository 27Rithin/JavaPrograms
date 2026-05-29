import java.io.*;
import java.util.*;

public class onetimepad
{

   public static void main(String[] args) throws IOException
   {
    
      Random r = new Random();

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Given plain text: ");

      String temp = br.readLine();

      temp = temp.toUpperCase();

      int length = temp.length();

      char plain[] = new char[length];

      char key[] = new char[length];

      char cipher[] = new char[length];

      char decipher[] = new char[length];


      for (int i = 0; i < length; i++)
      {

        key[i] = (char) + (65 + r.nextInt(26));

        cipher[i] = (char) ((int) (plain[i]) ^ (int) (key[i]));

        decipher[i] = (char) ((int) cipher[i] ^ (int) (key[i]));

      }

  System.out.println("Plain text: ");
   
  for (int i = 0; i < length; i++)
  {

    System.out.print(plain[i]);

  }

  System.out.println();

  System.out.println("key: ");
   
  for (int i = 0; i < length; i++)
  {

    System.out.print(key[i]);

  }

  System.out.println();

  System.out.println("cipher text: ");
   
  for (int i = 0; i < length; i++)
  {

    System.out.print(cipher[i]);

  }

  System.out.println();

  System.out.println("decipher text: ");
   
  for (int i = 0; i < length; i++)
  {

    System.out.print(decipher[i]);

  }

  System.out.println();







   }







}