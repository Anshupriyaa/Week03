import java.util.*;

public class CircularTour {
public static int findStartingPoint(int[] petrol, int[] distance) {
    int n = petrol.length;
    int totalPetrol = 0, totalDistance = 0, currentSurplus = 0;
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
        totalPetrol += petrol[i];
        totalDistance += distance[i];
    }

    // If total petrol is less than total distance, no solution exists
    if (totalPetrol < totalDistance) {
        return -1;
    }

    // Try to find the valid starting point
    for (int i = 0; i < n; i++) {
        currentSurplus += petrol[i] - distance[i];
        queue.offer(i); // Add current pump index to the queue

        // If surplus goes negative, remove pumps from the front of the queue
        while (currentSurplus < 0 && !queue.isEmpty()) {
            int removedPump = queue.poll(); // Remove from the front of the queue
            currentSurplus -= (petrol[removedPump] - distance[removedPump]);
        }

        // If queue size is equal to n, it means we completed the circular tour
        if (queue.size() == n) {
            return queue.peek(); // The first element in the queue is the valid start index
        }
    }

    return -1;
}

    // Test the function
public static void main(String[] args) {
    int[] petrol = {4, 6, 7, 4};
    int[] distance = {6, 5, 3, 5};

    int start = findStartingPoint(petrol, distance);
    System.out.println(start); // Output: 1
}
}
