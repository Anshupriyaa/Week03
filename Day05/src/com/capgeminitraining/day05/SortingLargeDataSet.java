package com.capgeminitraining.day05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static com.capgeminitraining.day05.SearchTarget.linearSearch;

public class SortingLargeDataSet {
    // Bubble Sort (O(N^2))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Measure execution time
    // Measure execution time
    public static long measureTime(Runnable sortingMethod) {
        long startTime = System.nanoTime();
        sortingMethod.run();
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        int N = 10000; // Change for larger dataset
        Random random = new Random();
        int[] data = random.ints(N, 0, 100000).toArray();

        // Copy original data for fair comparison
        int[] dataBubble = Arrays.copyOf(data, data.length);
        int[] dataMerge = Arrays.copyOf(data, data.length);
        int[] dataQuick = Arrays.copyOf(data, data.length);

        // Measure sorting times
        System.out.println("Sorting " + N + " elements...");
        System.out.println("Bubble Sort Time: " + measureTime(() -> bubbleSort(dataBubble)) / 1e6 + " ms");
        System.out.println("Merge Sort Time: " + measureTime(() -> mergeSort(dataMerge)) / 1e6 + " ms");
        System.out.println("Quick Sort Time: " + measureTime(() -> quickSort(dataQuick, 0, dataQuick.length - 1)) / 1e6 + " ms");

    }
}
