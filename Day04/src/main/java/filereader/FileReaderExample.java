package filereader;

import java.io.*;
public class FileReaderExample {
    public static void main(String[] args) {
        //we will provide the file name that we want to read
        String fileName = "sample.txt";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line= bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
