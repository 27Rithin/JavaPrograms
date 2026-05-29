import java.io.*;

public class CharStuffing
{

   public static void main(String[] args) throws IOException
    {
    
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         System.out.println("Enter the input: ");

         String data = br.readLine();


         String res = "DLESTX";

         int i;

         for (i = 0; i < data.length() - 2; i++)
         {

            if ((data.charAt(i) == 'd' || data.charAt(i) == 'D') &&

               (data.charAt(i + 1) == 'l' || data.charAt(i) == 'L') &&
 
                (data.charAt(i + 2) == 'e' || data.charAt(i + 2) == 'E'))

                {

                   res = res + "DLE";

                }

                res = res + data.charAt(i);
         }

           res = res + data.charAt(i) + data.charAt(i + 1) + "DLESTX";

          System.out.println("Output is: " + res);

   }




}