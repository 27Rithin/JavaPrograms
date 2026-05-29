import java.util.Scanner;

public class CyclomaticComplexity {

    public static void main(String[] args) {
        
          Scanner sc = new Scanner(System.in);

          int edges, nodes, complexity;

          System.out.print("Enter no.of Edges: ");
          edges = sc.nextInt();

          System.out.print("Enter no.of Nodes: ");
          nodes = sc.nextInt();

          complexity = edges - nodes + 2;


          System.out.println("The Cyclomatic Complexity of Graph is: " + complexity);
          sc.close();
          
          

    }

}
    

