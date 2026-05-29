import java.io.*;

public class BitStuffing
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Enter binary message: ");

      String data = br.readLine();

      String res = new String();

      int counter = 0;

      for (int i = 0; i < data.length(); i++)
      {

          if ((data.charAt(i) != '1') && (data.charAt(i) != '0'))
          {

              System.out.println("Enter only binary values: ");
              return;

          }

          if (data.charAt(i) == 1)
          {

              counter++;

              res = res + data.charAt(i);

          }

          else

          {


             res = res + data.charAt(i);

             counter = 0;


          }

        if (counter == 5)
        {

           res = res + '0';
           counter = 0;



        }

      }


        System.out.println("the encrypted string is: " + res);

   }




}