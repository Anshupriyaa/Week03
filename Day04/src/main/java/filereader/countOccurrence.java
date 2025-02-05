package filereader;

import java.io.*;
import java.util.Scanner;
public class countOccurrence {
    //main method
    public static void main(String[] args) {
        //name of the file in which we want to search the word
        String file_name ="C:\\Week03\\Day04\\src\\main\\java\\filereader\\sample.txt";
        int counter=0;
        //creating the instance of Scanner class
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the word that needs to be search :");
        String wordToSearch=sc.next();
        try(FileReader fileReader=new FileReader(file_name);
            BufferedReader bufferedReader= new BufferedReader(fileReader)){
            String line;
            while((line=bufferedReader.readLine())!= null){
                if(line.contains(wordToSearch)){
                    counter++;
                }
            }
        }catch (IOException e){
            System.out.println("Error while reading the file" + e.getMessage());

        }
        System.out.println("The word " + wordToSearch + " appears " + counter +" times in the file. ");
        sc.close();
    }
}

