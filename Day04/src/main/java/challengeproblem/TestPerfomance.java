package challengeproblem;

import java.io.*;
import java.nio.charset.StandardCharsets;
 class TestPerformance{
    //main method
    public static void main(String[] args) {
        // Test StringBuilder and StringBuffer performance
        testStringConcatenation();

        // Test FileReader and InputStreamReader performance
        String filePath = "C:\\Week03\\Day04\\src\\main\\java\\challengeproblem\\largefile.txt";
        countWordsUsingFileReader(filePath);
        countWordsUsingInputStreamReader(filePath);
    }
    public static void testStringConcatenation() {
        final int iterations = 1_000_000;
        String testString = "hello";

        // Using StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(testString);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void countWordsUsingFileReader(String filePath) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount);
        System.out.println("FileReader time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void countWordsUsingInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        int wordCount = 0;

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount);
        System.out.println("InputStreamReader word count: " + wordCount);
        System.out.println("InputStreamReader time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
