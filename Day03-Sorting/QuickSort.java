import java.util.Scanner;

public class QuickSort {
    //method to print the array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //method to recursively call quicksort method to sort the price array
    public static void quickSort(int arr[], int start , int end){
        if(start>=end){
            return;
        }
        int pivotIdx=partition(arr,start,end);
        quickSort(arr, start, pivotIdx-1);
        quickSort(arr, pivotIdx+1, end);
    }
    //method to find correct index of pivot element
    public static int partition(int arr[],int start, int end){
        int pivot=arr[end];
        //IDX VARIABLE TO STORE ELEMENT LESSER THAN PIVOT
        int idx=start-1;
        int j;
        for( j=start;j<=end;j++){
            if(arr[j]<pivot){
                idx++;
                int temp=arr[j];
                arr[j]=arr[idx];
                arr[idx]=temp;
            }
        }
        idx++;
        int temp=arr[end];
        arr[end]=arr[idx];
        arr[idx]=pivot;

        return idx;
    }
    //main method
    public static void main(String[] args) {
        // Creating Scanner object
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of product: ");
        int numOfProduct = input.nextInt();
        // Array to store product prices
        int price[] = new int[numOfProduct];
        // Taking user input for product prices
        System.out.println("Enter prices of Prdocut: ");
        for (int i = 0; i < price.length; i++) {
            price[i] = input.nextInt();
        }
        // Printing the array before sorting
        System.out.print("Array before sorting: ");
        printArray(price);
        // Sorting the array
        quickSort(price, 0, price.length - 1);
        // Printing the array after sorting
        System.out.print("Array after sorting: ");
        printArray(price);
        input.close();
    }
}
