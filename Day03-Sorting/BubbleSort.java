import java.util.Scanner;
public class BubbleSort {
    public static void main(String[] args) {
        //creating the instance of Scanner class
        Scanner input=new Scanner(System.in);
        //aray to store markes of Students
        int noOfStudents=input.nextInt();
        int marks[]=new int[noOfStudents];
        //loop to take input marks from user
        for(int i=0;i<marks.length;i++){
            marks[i]=input.nextInt();
        }
        int n=marks.length;
        //loop to sort the array using Bubble sort
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(marks[j]>marks[j+1]){
                    int temp=marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                }
            }
        }
        //loop to print the sorted array
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i] +" ");
        }
        input.close();
    }
    
}