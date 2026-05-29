import java.util.Scanner;
class practices
{

    public static void main(String args[])
    {

        int a,b,c;
 
        int s;
        double area;
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the values a,b,c");
        
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        s = (a + b + c) / 2;

        area = Math.sqrt(s*(s-a)*(s-b)*(s-c));

        System.out.println("AREA IS: " + area);
       

    }
}

