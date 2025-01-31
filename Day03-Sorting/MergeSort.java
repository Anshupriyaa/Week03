import java.util.Scanner;

public class MergeSort {
    // Method to print the array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Merge Sort Function
    public static void mergeSort(int arr[], int start, int end) {
        if (start >= end) { 
            return;
        }
        int mid = start + (end - start) / 2; 
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    // Merge Function
    public static void merge(int arr[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        //k variable to iterate temp array
        int k = 0;

        // Merge elements from both half into temp[]
        while (i <= mid && j <= end) { 
            if (arr[i] <= arr[j]) { 
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // Copy remaining elements from left subarray 
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // Copy remaining elements from right subarray 
        while (j <= end) { // Fixed condition
            temp[k++] = arr[j++];
        }
        // Copy sorted elements back to original array
        for (k = 0, i = start; k < temp.length; k++, i++) { // Fixed loop
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        // Creating Scanner object
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int numOfBooks = input.nextInt();

        // Array to store book prices
        int price[] = new int[numOfBooks];

        // Taking user input for book prices
        System.out.println("Enter prices of books: ");
        for (int i = 0; i < price.length; i++) {
            price[i] = input.nextInt();
        }

        // Printing the array before sorting
        System.out.print("Array before sorting: ");
        printArray(price);

        // Sorting the array
        mergeSort(price, 0, price.length - 1);

        // Printing the array after sorting
        System.out.print("Array after sorting: ");
        printArray(price);

        input.close();
    }
}
