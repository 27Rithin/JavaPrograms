import java.util.Scanner;


 public class MergeSort

{

  public static void sort(int[] arr, int low, int high)

{

   if(high - low <= 1) 

   return;

   int mid = (low + high) / 2;

   sort(arr, low, mid);

   sort(arr, mid, high);


   int[] temp = new int[high - low];

   int i = low, j = mid, k = 0;
  

   while (i < mid && j < high)
    
       temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];


  while (i < mid) temp[k++] = arr[i++];

  while (j < high) temp[k++] = arr[j++];

  for(int m = 0; m < temp.length; m++)

      arr[low + m] = temp[m];

   
}

 
   public static void main(String[] args)

{

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of elements: ");

    int n = sc.nextInt();

    int[] arr = new int[n];


    System.out.println("Enter " + n + " elements:");
  
    for(int i = 0; i < n; i++)

      arr[i] = sc.nextInt();

    
     sort(arr, 0, n);


     System.out.println("Sorted array:");

     for(int num : arr)

       System.out.println(num + " ");


}



}