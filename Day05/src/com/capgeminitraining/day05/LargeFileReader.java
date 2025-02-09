package com.capgeminitraining.day05;

import java.io.*;

public class LargeFileReader{
    public static void main(String[] args) {
        String filePath = "C:\\Week03\\Day05\\src\\com\\capgeminitraining\\day05";
        long fileReaderTime = measureFileReaderTime(filePath);
        long inputStreamReaderTime = measureInputStreamReaderTime(filePath);
        System.out.println("FileReader Time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
        System.out.println("InputStreamReader is faster than FileReader");
    }

    private static long measureFileReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.read() != -1) {} // Read character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long measureInputStreamReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.read() != -1) {} // Read character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }
}

