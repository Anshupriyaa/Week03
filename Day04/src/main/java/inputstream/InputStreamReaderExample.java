package inputstream;

import java.io.*;
public class InputStreamReaderExample{
    public static void main(String[] args) {
        // Define the file name where input will be written
        String fileName = "output.txt";

        try (
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                FileWriter fw = new FileWriter(fileName, true); // Append mode
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            System.out.println("Enter text (type 'exit' to stop):");
            String line;

            while ((line = br.readLine()) != null) {
                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                bw.write(line);
                bw.newLine(); // Write new line to the file
            }

            System.out.println("Input saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

