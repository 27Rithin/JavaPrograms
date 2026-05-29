class Array
{
    public static void main(String[] args)
     {
       int number[]={55,40,20,65,70};
       int n = number.length;
       System.out.println("given list : "); 
       for (int i = 0; i < n; i++)
        {
           System.out.println("" + number[i]);
       }
       for (int i = 0; i < n; i++)
        {
           for(int j = i+1;j<n;j++)
           {
            if(number[i] < number[j])
            {
                int temp = number[i];
                number[i] = number[j];
                number[j] = temp;
            }
           }
       }
       System.out.println("sorted list");
       {
        for (int i = 0; i < n; i++) 
        {
            System.out.println(" " + number[i]);

        }
        System.out.println(" ");
       }
    }
} 
    