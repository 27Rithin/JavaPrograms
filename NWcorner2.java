// PROGRAM FOR NORTHWEST CORNER METHOD AND MINIMUM COST METHOD
public class NWcorner2 {

    public static void main(String[] args) {
        int[] supply = {100, 200, 300}; // Supply from 3 sources
        int[] demand = {150, 350, 100}; // Demand at 3 destinations
        int[][] cost = {
            {11, 12, 14}, // Cost from source 0 to all destinations
            { 9, 19, 10}, // Cost from source 1
            {25, 12, 17}  // Cost from source 2
        };

        int nwCost = NorthWest(supply, demand, cost); // Northwest corner solution
        int minCost = MinCost(supply, demand, cost);  // Minimum cost solution
        percentSaved(nwCost, minCost);                // Savings in percentage
    }

    // 🔷 NORTHWEST CORNER METHOD
    public static int NorthWest(int[] s, int[] d, int[][] c) {
        int[][] table = new int[s.length][d.length];  // Allocation table
        int[] supply = s.clone();
        int[] demand = d.clone();
        int totalCost = 0;

        for (int i = 0; i < supply.length; i++) {
            for (int j = 0; j < demand.length; j++) {
                if (supply[i] == 0) break;
                if (demand[j] == 0) continue;

                int alloc = Math.min(supply[i], demand[j]);
                table[i][j] = alloc;
                supply[i] -= alloc;
                demand[j] -= alloc;

                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < s.length; i++)
            for (int j = 0; j < d.length; j++)
                totalCost += c[i][j] * table[i][j];

        System.out.println("Total Cost = $" + totalCost);
        return totalCost;
    }

    // 🔷 MINIMUM COST METHOD (Simplified)
    public static int MinCost(int[] s, int[] d, int[][] c) {
        int[][] table = new int[s.length][d.length];
        int[] supply = s.clone();
        int[] demand = d.clone();
        int totalCost = 0;

        while (true) {
            int minCost = Integer.MAX_VALUE, row = -1, col = -1;

            // Find the cell with the minimum cost
            for (int i = 0; i < supply.length; i++) {
                for (int j = 0; j < demand.length; j++) {
                    if (supply[i] > 0 && demand[j] > 0 && c[i][j] < minCost) {
                        minCost = c[i][j];
                        row = i;
                        col = j;
                    }
                }
            }

            if (row == -1) break; // Allocation complete

            int alloc = Math.min(supply[row], demand[col]);
            table[row][col] = alloc;
            supply[row] -= alloc;
            demand[col] -= alloc;

            System.out.println("table " + alloc);
            System.out.println(row + " " + col);
            System.out.println("supply " + supply[row]);
            System.out.println("demand " + demand[col]);
        }

        for (int i = 0; i < s.length; i++)
            for (int j = 0; j < d.length; j++)
                totalCost += c[i][j] * table[i][j];

        System.out.println("Total Cost = $" + totalCost);
        return totalCost;
    }

    // 🔷 PERCENTAGE SAVED CALCULATION
    public static void percentSaved(int nwCost, int minCost) {
        double saved = ((double)(nwCost - minCost) / nwCost) * 100;
        System.out.printf("Percentage saved: %.2f%%\n", saved);
    }
}
