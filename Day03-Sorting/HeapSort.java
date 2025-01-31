
import java.util.Scanner;
public class HeapSort {
    //method to print the array
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();

    }
    // Function to sort an array using Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swap the root with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }
    // heapify method
    private static void heapify(int[] arr, int n, int i) {
        // Initialize largest as root
        int largest = i; 
        //left and right child
        int left = 2 * i + 1; 
        int right = 2 * i + 2;
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    // Main method to test Heap Sort
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int numOfEmployees=input.nextInt();
        //ARRAY TO STORE SALARAIES OF EMPLOYEES
        int salaries[]=new int[numOfEmployees];
        //loop to take input from user
        System.out.println("Enter Salary :");
        for(int i=0;i<salaries.length;i++){
            salaries[i]=input.nextInt();
        }
        
        System.out.println("Original salary demands: " );
        printArray(salaries);
        
        heapSort(salaries);
        
        System.out.println("Sorted salary demands: " );
        printArray(salaries);
    }
}