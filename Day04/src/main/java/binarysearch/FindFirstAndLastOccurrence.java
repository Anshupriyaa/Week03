package binarysearch;
import java.util.*;
public class FindFirstAndLastOccurrence {


        // Method to find the first occurrence of the element
        public static int findFirstOccurrence(int[] array, int element, int start, int end) {
            int result = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (array[mid] == element) {
                    result = mid;
                    // Continue searching to the left (lower indices)
                    end = mid - 1;
                } else if (array[mid] < element) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return result;
        }
        // Method to find the last occurrence of the element
        public static int findLastOccurrence(int[] array, int element, int start, int end) {
            int result = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (array[mid] == element) {
                    result = mid;
                    // Continue searching to the right (higher indices)
                    start = mid + 1;
                } else if (array[mid] < element) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return result;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Input the element to search for
            System.out.print("Enter the element to search : ");
            int element = sc.nextInt();

            // Input the size of the array
            System.out.print("Enter the size of the array: ");
            int N = sc.nextInt();
            int[] array = new int[N];

            // Input the array elements (ensure the array is sorted)
            System.out.println("Enter the sorted array elements:");
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            // Find first and last occurrences using modified binary search
            int firstIndex = findFirstOccurrence(array, element, 0, array.length - 1);
            int lastIndex = findLastOccurrence(array, element, 0, array.length - 1);
            // Print results
            if (firstIndex == -1) {
                System.out.println("Element doesn't exist in the array.");
            } else {
                System.out.println("First Occurrence: " + firstIndex);
                System.out.println("Last Occurrence: " + lastIndex);
            }
            sc.close();
        }
}



