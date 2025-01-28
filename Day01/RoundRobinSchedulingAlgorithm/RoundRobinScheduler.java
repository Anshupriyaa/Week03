class Process {
    int processID;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private int totalProcesses = 0;

    // Add a new process to the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head; // Circular link
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
        totalProcesses++;
        System.out.println("Process added: ID=" + processID + ", Burst Time=" + burstTime + ", Priority=" + priority);
    }

    // Remove a process from the circular list
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("No processes to remove!");
            return;
        }

        Process current = head, prev = null;

        do {
            if (current.processID == processID) {
                if (prev == null) { // Removing the head node
                    Process temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    if (head == head.next) { // Only one node
                        head = null;
                    } else {
                        temp.next = head.next;
                        head = head.next;
                    }
                } else { // Removing a non-head node
                    prev.next = current.next;
                }
                totalProcesses--;
                System.out.println("Process removed: ID=" + processID);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process not found: ID=" + processID);
    }

    // Simulate the Round-Robin scheduling
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule!");
            return;
        }

        int time = 0; // Current time
        Process current = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        System.out.println("\nStarting Round-Robin Scheduling:");
        while (totalProcesses > 0) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= executionTime;
                time += executionTime;

                System.out.println("Process " + current.processID + " executed for " + executionTime + " units. Remaining Time: " + current.remainingTime);

                if (current.remainingTime == 0) { // Process completed
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;

                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;

                    System.out.println("Process " + current.processID + " completed. Turnaround Time: " + turnaroundTime + ", Waiting Time: " + waitingTime);

                    Process completed = current;
                    current = current.next;
                    removeProcess(completed.processID);
                } else {
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }

        System.out.println("\nScheduling Complete:");
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / (totalProcesses == 0 ? 1 : totalProcesses));
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / (totalProcesses == 0 ? 1 : totalProcesses));
    }

    // Display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }

        Process temp = head;
        System.out.println("\nCurrent Processes in the Queue:");
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);

        scheduler.displayProcesses();

        scheduler.simulate(3); // Fixed time quantum of 3
    }
}
