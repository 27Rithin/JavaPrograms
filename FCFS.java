import java.util.Scanner;

class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];
        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] completionTime = new int[n];

        // Input process details
        System.out.println("Enter arrival time and burst time for each process:");
        for (int i = 0; i < n; i++) {
            process[i] = i + 1;
            System.out.print("Process " + process[i] + " Arrival Time: ");
            arrivalTime[i] = sc.nextInt();
            System.out.print("Process " + process[i] + " Burst Time: ");
            burstTime[i] = sc.nextInt();
        }

        // Sort processes by arrival time
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrivalTime[j] > arrivalTime[j + 1]) {
                    // Swap arrival time
                    int temp = arrivalTime[j];
                    arrivalTime[j] = arrivalTime[j + 1];
                    arrivalTime[j + 1] = temp;

                    // Swap burst time
                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    // Swap process ID
                    temp = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp;
                }
            }
        }

        // Calculate completion, waiting, and turnaround times
        completionTime[0] = arrivalTime[0] + burstTime[0];
        for (int i = 1; i < n; i++) {
            completionTime[i] = Math.max(completionTime[i - 1], arrivalTime[i]) + burstTime[i];
        }
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
        }

        // Output results
        System.out.println("\nProcess\tArrival\tBurst\tCompletion\tWaiting\tTurnaround");
        float totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(process[i] + "\t" + arrivalTime[i] + "\t" + burstTime[i] + "\t" +
                    completionTime[i] + "\t\t" + waitingTime[i] + "\t" + turnaroundTime[i]);
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        // Display averages
        System.out.println("\nAverage Waiting Time: " + (totalWaitingTime / n));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / n));

        sc.close();
    }
}
