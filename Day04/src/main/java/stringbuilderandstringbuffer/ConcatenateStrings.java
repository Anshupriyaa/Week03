package stringbuilderandstringbuffer;

import java.util.Scanner;
import java.lang.StringBuffer;
public class ConcatenateStrings{
    public static String concatenate(String array[]){
        StringBuffer sb=new StringBuffer();
        //loop to traverse array and concatenate into string buffer
        for(int i=0;i<array.length; i++){
            sb.append(array[i]);
            sb.append(" ");
        }
        //returning the string buffer after converting it into String
        return sb.toString();

    }
    public static void main(String[] args) {
        //creating the instance of Scanner class
        Scanner input=new Scanner(System.in);
        //initializing an array to store string of n size
        int n= input.nextInt();
        String [] array =new String[n];
        //loop to take user input
        for(int i=0;i<array.length;i++){
            array[i]=input.next();
        }
        //calling the method that will
        //and storing the output in new sting variable
        String newString =concatenate(array);
        System.out.println("printing the string after concatenation : " + newString);
        input.close();
    }

}