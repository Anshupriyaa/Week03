package stringbuilderandstringbuffer;

import java.util.Scanner;
import java.lang.String;
import java.lang.StringBuilder;
public class ReverseString{
    public static String reverseString(String str){
        //creating a new String Builder object
        StringBuilder sb=new StringBuilder(str);
        /* reversing the string and then converting the string builder to string and then returning it*/
        return sb.reverse().toString();

    }

    //main method
    public static void main(String[] args) {
        //creating the instance of Scanner class
        Scanner input=new Scanner(System.in);
        String str=input.next();
        /*calling the reverse method  and storing the resultant string into new string variable*/
        String resultString=reverseString(str);
        //printing the original as well as modified string
        System.out.println("Original String : " + str);
        System.out.println("String after reversing it: "+ resultString);
        input.close();

    }
}