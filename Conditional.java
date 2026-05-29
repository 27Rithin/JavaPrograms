import java.util.Scanner;
public class Conditional
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int marks;
        System.out.println("Enter the student marks");
        marks=sc.nextInt();
        if(marks>35)
        {
            System.out.println("Student is fail");
        }
        else if (marks>=85 && marks<=50)
        {
            System.out.println("Student got D grade");
        }
        else if(marks>=60 && marks<=75)
        {
            System.out.println("student got C grade");
        }
        else if(marks>=75 && marks<=85)
        {
            System.out.println("student got B grade");
        }
        else if(marks>=85 && marks<=100)
        {
            System.out.println("student got A grade");
        }
        else
        {
            System.out.println("enter valid marks");
        }
    }
}