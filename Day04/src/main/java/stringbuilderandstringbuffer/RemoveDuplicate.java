package stringbuilderandstringbuffer;

import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.HashSet;
public class RemoveDuplicate {
    public static String modifyString(String string){
        //initializing a hashSet to store unique character
        HashSet<Character>set=new HashSet<>();
        //initializing a empty string builder to store unique character
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<string.length();i++){
            char curr= string.charAt(i);
            if(!set.contains(curr)){
                sb.append(curr);
            }
            set.add(curr);
        }
        //converting StringBuilder to string and then returning it
        return sb.toString();
    }
    //main method
    public static void main(String[] args) {
        //instance of Scanner class
        Scanner input=new Scanner(System.in);
        String string =input.next();
        //invoking the method that will return the string with unique characters
        //and then storing the output in new String variable
        String modifiedStr=modifyString(string);
        //printing the original string and modified string
        System.out.println("Original String : " + string);
        System.out.println("String after modifying  it: " + modifiedStr);
        input.close();
    }

}

