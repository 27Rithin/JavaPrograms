import java.io.*;

public class FPValue {

    int count[] = new int[6];

    int avg[] = new int[6];

    int ct[] = new int[6];

    int ctotal;

    int fi;

    float fp;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    FPValue()
    {

       System.out.println("\n\tFunction Point (FP) Value Calculation");

       System.out.println("\t---------------------");

       ctotal = 0;

       fi = 0;
        
       fp = 0;

    }

     void input() throws IOException {

               for (int i = 1; i <= 5; i++)
               {

                  if (i == 1)
                     System.out.print("\nEnter number of External Inputs: ");

                  else if (i == 2)
                        System.out.print("\nEnter number of External Outputs: ");

                    else if (i == 3)
                        System.out.print("\nEnter number of External Inquiries: ");
                        
                    else if (i == 4)
                        System.out.print("\nEnter number of Internal Logical Files: ");
                        
                    else
                        System.out.print("\nEnter number of External Interfaces: ");
                        
                        
                        count[i] = Integer.parseInt(br.readLine());

               }

          System.out.println("Enter Average Complexity Adjustment Values (for 5 components): ");

          for (int i = 1; i <= 5; i++)
          {

             System.out.print("Value " + i + ": ");

             avg[i] =  Integer.parseInt(br.readLine());

          }

         System.out.print("\nEnter sum of value Adjustment Factors (fi): ");

        fi = Integer.parseInt(br.readLine());

     }

    void process()
    {

        for (int j = 0; j <= 5; j++)
        {
 
           ct[j] = count[j] * avg[j];

           ctotal += ct[j];

        }

        fp = ctotal * (0.65f + (0.01f * fi));

    }

    void output()
    {

         System.out.print("\n\nCount Total = " + ctotal);
         System.out.println("Sum of fi = " + fi);
         System.out.println("\nFormula: FP = Count Total * (0.65 + 0.01 * fi)");
         System.out.println("\nFunctional Point (FP) Value = " + fp);
         
    }

    public static void main(String args[]) throws IOException
    {
        FPValue obj = new FPValue();

       obj.input();

        obj.process();

        obj.output();
    }
}

