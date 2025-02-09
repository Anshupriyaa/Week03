package com.capgeminitraining.day05;

public class FibonacciComparison {
    public static int N = 30;
    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        long startTime, endTime;
        // Recursive Fibonacci
        startTime = System.nanoTime();
        int fibRec = fibonacciRecursive(N);
        endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci Result: " + fibRec);
        System.out.println("Recursive Time: " + (endTime - startTime) / 1_000_000 );
        // Iterative Fibonacci
        startTime = System.nanoTime();
        int fibIter = fibonacciIterative(N);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci Result: " + fibIter);
        System.out.println("Iterative Time: " + (endTime - startTime) / 1_000_000 );
        System.out.println("Recursive approach is slow for large N ");
        System.out.println("Iterative approach is efficient ");

    }
}

