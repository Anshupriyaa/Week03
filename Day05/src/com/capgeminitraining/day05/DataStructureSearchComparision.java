package com.capgeminitraining.day05;

import java.util.*;

class DataStructureSearchComparison {
    public static final int N = 1_000_000; // Change this for different dataset sizes
    public static final int SEARCH_ELEMENT = N / 2; // Element to search
    // Measure execution time for Array search
    public static long testArraySearch(int[] array) {
        long startTime = System.nanoTime();
        for (int num : array) {
            if (num == SEARCH_ELEMENT) {
                break;
            }
        }
        //return the time after converting into milliseconds
        return (System.nanoTime() - startTime) / 1_000_000;
    }
    // Measure execution time for HashSet search
    public static long testHashSetSearch(HashSet<Integer> hashSet) {
        long startTime = System.nanoTime();
        hashSet.contains(SEARCH_ELEMENT);
        return (System.nanoTime() - startTime) / 1_000_000;
    }
    // Measure execution time for TreeSet search
    public static long testTreeSetSearch(TreeSet<Integer> treeSet) {
        long startTime = System.nanoTime();
        treeSet.contains(SEARCH_ELEMENT);
        return (System.nanoTime() - startTime) / 1_000_000;
    }
    //main method
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Populate data structures
        for (int i = 0; i < N; i++) {
            int value = random.nextInt(N);
            array[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }
        System.out.println("Searching in " + N + " elements...");
        // Searching in Array
        long timeArray = testArraySearch(array);
        System.out.println("Array Search Time: " + timeArray + " ms (Slowest)");
        // Searching in HashSet (O(1))
        long timeHashSet = testHashSetSearch(hashSet);
        System.out.println("HashSet Search Time: " + timeHashSet + " ms (Fastest )");
        // Searching in TreeSet (O(log N))
        long timeTreeSet = testTreeSetSearch(treeSet);
        System.out.println("TreeSet Search Time: " + timeTreeSet + " ms (Sorted but slightly slower than HashSet)");
    }
}

