import java.util.*;

public class RoundRobinScheduling {

    static class Process {
        int id;         // Process ID
        int burstTime;  // Burst Time
        int remainingTime; // Remaining Burst Time
        int waitingTime;   // Waiting Time
        int turnaroundTime; // Turnaround Time

        // Constructor to initialize a process
        Process(int id, int burstTime) {
            this.id = id;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.waitingTime = 0;
            this.turnaroundTime = 0;
        }
    }

    // Function to perform the Round Robin Scheduling
    public static void roundRobinScheduling(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>();
        int currentTime = 0;

        // Add all processes to the queue initially
        for (Process process : processes) {
            queue.add(process);
        }

        // Process execution loop
        while (!queue.isEmpty()) {
            Process process = queue.poll();

            if (process.remainingTime > quantum) {
                // If the process needs more time, reduce the remaining time and add it back to the queue
                process.remainingTime -= quantum;
                currentTime += quantum;
                queue.add(process);
            } else {
                // If the process completes in this time slice
                currentTime += process.remainingTime;
                process.waitingTime = currentTime - process.burstTime;
                process.turnaroundTime = currentTime;
                process.remainingTime = 0;
            }
        }
    }

    // Function to calculate average waiting time and turnaround time
    public static void calculateAverages(List<Process> processes) {
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        for (Process process : processes) {
            totalWaitingTime += process.waitingTime;
            totalTurnaroundTime += process.turnaroundTime;
        }

        int n = processes.size();
        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    // Function to display the results
    public static void displayResults(List<Process> processes) {
        System.out.println("Process ID | Burst Time | Waiting Time | Turnaround Time");
        for (Process process : processes) {
            System.out.println("    P" + process.id + "     |    " + process.burstTime +
                    "     |      " + process.waitingTime + "      |      " + process.turnaroundTime);
        }
    }

    // Main driver function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        List<Process> processes = new ArrayList<>();

        // Get burst times for each process
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter burst time for process P" + i + ": ");
            int burstTime = sc.nextInt();
            processes.add(new Process(i, burstTime));
        }

        System.out.print("Enter the time quantum: ");
        int quantum = sc.nextInt();

        // Perform the Round Robin Scheduling
        roundRobinScheduling(processes, quantum);

        // Display the results
        displayResults(processes);

        // Calculate and display averages
        calculateAverages(processes);
    }
}
