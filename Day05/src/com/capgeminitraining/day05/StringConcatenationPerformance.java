package com.capgeminitraining.day05;

public class StringConcatenationPerformance {
    public static int N = 1_000_000;
    // Measure execution time for String concatenation
    public static long testStringConcatenation() {
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // Inefficient due to immutability
        }
        return (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds
    }

    // Measure execution time for StringBuilder
    public static long testStringBuilderConcatenation() {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }

    // Measure execution time for StringBuffer
    public static long testStringBufferConcatenation() {
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i = 0; i < N; i++) {
            sbf.append("a");
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }
    public static void main(String[] args) {
        System.out.println("Concatenating " + N + " strings...");

        long timeString = testStringConcatenation();
        System.out.println("String Time: " + timeString + " ms (Very slow )");

        long timeStringBuilder = testStringBuilderConcatenation();
        System.out.println("StringBuilder Time: " + timeStringBuilder + " ms (Fastest )");

        long timeStringBuffer = testStringBufferConcatenation();
        System.out.println("StringBuffer Time: " + timeStringBuffer + " ms (Thread-safe but slightly slower tha String Builder)");
    }
}

