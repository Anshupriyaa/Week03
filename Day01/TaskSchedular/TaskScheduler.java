

public class TaskScheduler {
    static class TaskNode {
        String taskId;
        String taskName;
        int priority;
        String dueDate; // You can use Date for real scenarios
        TaskNode next;

        TaskNode(String taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode currentTask = null; // For moving between tasks

    // Add a task at the beginning
    public void addAtBeginning(String taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular linking
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular structure
        }
    }

    // Add a task at the end
    public void addAtEnd(String taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular linking
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular structure
        }
    }

    // Add a task at a specific position
    public void addAtPosition(String taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode temp = head;
        int count = 1;

        while (count < position - 1 && temp != tail) {
            temp = temp.next;
            count++;
        }

        if (temp == tail && count < position - 1) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
            tail.next = head; // Maintain circular structure
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(String taskId) {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        // Check if the head node itself has the task ID
        if (head.taskId.equals(taskId)) {
            if (head == tail) { // Single node case
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head; // Maintain circular structure
            }
            return;
        }

        // Traverse the list to find the node to remove
        do {
            prev = temp;
            temp = temp.next;
            if (temp.taskId.equals(taskId)) {
                prev.next = temp.next;
                if (temp == tail) { // If the node to be removed is the tail
                    tail = prev;
                    tail.next = head; // Maintain circular structure
                }
                return;
            }
        } while (temp != head);

        System.out.println("Task not found!");
    }

    // View the current task and move to the next task
    public void viewAndMoveToNextTask() {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }

        if (currentTask == null) {
            currentTask = head;
        }

        displayTask(currentTask);
        currentTask = currentTask.next; // Move to the next task
    }

    // Display all tasks in the circular list
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }

        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    // Display a single task
    private void displayTask(TaskNode task) {
        System.out.println("Task ID: " + task.taskId);
        System.out.println("Task Name: " + task.taskName);
        System.out.println("Priority: " + task.priority);
        System.out.println("Due Date: " + task.dueDate);
        System.out.println();
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addAtBeginning("T001", "Task A", 1, "2025-01-31");
        scheduler.addAtEnd("T002", "Task B", 2, "2025-02-10");
        scheduler.addAtPosition("T003", "Task C", 3, "2025-02-20", 2);

        // Display all tasks
        System.out.println("All tasks:");
        scheduler.displayAllTasks();

        // Remove a task
        scheduler.removeTaskById("T002");
        System.out.println("After removing Task B:");
        scheduler.displayAllTasks();

        // Search tasks by priority
        System.out.println("Tasks with priority 3:");
        scheduler.searchByPriority(3);

        // View and move to the next task
        System.out.println("Current task and move to the next:");
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();

        // Display all tasks again to ensure circular structure
        System.out.println("All tasks after traversing circularly:");
        scheduler.displayAllTasks();
    }
}
