import java.util.Scanner;
class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        int[] pid = new int[n]; // Process IDs
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] completionTime = new int[n];

        System.out.println("Enter Burst Time for each process:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
            pid[i] = i + 1; // Assign process ID
        }

        // Sort processes by Burst Time (using Bubble Sort for simplicity)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (burstTime[j] > burstTime[j + 1]) {
                    // Swap burst times
                    int temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    // Swap process IDs
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }

        // Calculate Completion Time
        completionTime[0] = burstTime[0];
        for (int i = 1; i < n; i++) {
            completionTime[i] = completionTime[i - 1] + burstTime[i];
        }

        // Calculate Turnaround Time and Waiting Time
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = completionTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        // Display results
        System.out.println("\nProcess\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t\t" + burstTime[i] + "\t\t" + completionTime[i] + "\t\t" + turnaroundTime[i] + "\t\t" + waitingTime[i]);
        }

        // Calculate and display averages
        System.out.println("\nAverage Turnaround Time: " + (double) totalTurnaroundTime / n);
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / n);

        sc.close();
    }
}
