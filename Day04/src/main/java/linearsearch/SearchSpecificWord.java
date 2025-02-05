package linearsearch;

import java.util.Scanner;

public class SearchSpecificWord {
    //method to search a word in the sentence
    public static String searchWord(String[] sentence,String word){
        //loop for traversing all the sentences in a string array
        for(int i=0;i<sentence.length;i++){
            //condition for checking whether sentence contains the given word or not
            if(sentence[i].contains(word)){
                return sentence[i];
            }
        }
        return "Not Found";
    }
    public static void main(String[] args){
        //Scanner class for taking input from the user
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of your array");
        //size will store the size of an array
        int size=sc.nextInt();
        String[] sentence=new String[size];
        System.out.println("Enter sentences");
        //loop for taking sentences from the user
        for(int i=0;i<sentence.length;i++){
            sentence[i]=sc.nextLine();
        }
        System.out.println("Enter word");
        //word will store the word which we have to search in the given string array
        String word=sc.next();
        //here we are storing the obtained answer from the above method
        String result=searchWord(sentence,word);
        //printing the result got from the above method
        System.out.println(result);
        sc.close();
    }
}


