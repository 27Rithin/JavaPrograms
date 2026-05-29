import java.util.Scanner;
  public class EmployeeDetails 
   {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        try 
        {
            System.out.print("Enter Employee ID (numeric): ");
            int empId = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Employee Name: ");
            String empName = scanner.nextLine();

            System.out.print("Enter Employee Age: ");
            int empAge = Integer.parseInt(scanner.nextLine());

            if(empAge < 18 || empAge > 65)
            {
                throw new IllegalArgumentException("Age must be between 18 and 65");

            }
            System.out.println("Employee Details:");
            System.out.println("ID: " + empId);
            System.out.println("Name: " + empName);
            System.out.println("Age: " + empAge);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: please enter valid numeric values for Id and age");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
       finally 
       {
        scanner.close();
        System.out.println("program execution completed");
       } 
    }
   }
