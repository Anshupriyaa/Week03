package linearsearch;

import java.util.Scanner;

public class SearchNegativeNumber {
    public static int findNegative(int[] number){
        //loop for traversing all the elements present in an array
        for(int i=0;i<number.length;i++){
            //condition for checking whether the given number is positive or negative
            if(number[i]<0){
                return i;
            }
        }
        //if no negative number is found in an array then we will return -1
        return -1;
    }
    public static void main(String[] args){
        //Scanner class for taking input from the user
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of your array: ");
        //size will store size of an array
        int size=sc.nextInt();
        int[] number=new int[size];
        System.out.println("Enter numbers in the array: ");
        //loop for taking elements of an array from the user
        for(int i=0;i<number.length;i++){
            number[i]=sc.nextInt();
        }
        // method call
        int result=findNegative(number);

        if(result!=-1){
            System.out.println("Negative number is found at index: "+result);
        }else{
            System.out.println("No negative number is found in the given array");
        }
        sc.close();
    }
}


