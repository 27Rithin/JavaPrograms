import java.io.*;

import java.lang.String.*;


class Transposition
{

   public static void main(String args[]) throws IOException
{

    String temp;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter plain text:");

    temp = br.readLine();

    int length = temp.length();
  
    int templength = (length + length / 4);

    char plain[]  = new char[templength + 1];
 
    char cipher[]  = new char[templength + 1];

    char decipher[]  = new char[templength + 1];

    int x, y, j, k;
  
    for(int i = 0; i < length; i++)

        plain[i] = temp.charAt(i);

    



    


}



}