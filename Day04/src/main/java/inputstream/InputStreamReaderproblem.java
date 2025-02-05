package inputstream;

import java.io.*;
import java.nio.charset.StandardCharsets;

class InputStreamReaderProblem{
    //main method
    public static void main(String[] args) {
        // Define the file name to read from
        String fileName ="C:\\Week03\\Day04\\src\\main\\java\\inputstream\\output.txt";

        try (
                FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
