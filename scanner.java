//to find the area of rectangle 
import java.util.Scanner;
class Rectangle
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int breadth = s.nextInt();
        int area = length * breadth;
        System.out.println(area);
    }
}