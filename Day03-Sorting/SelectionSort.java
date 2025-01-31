import java.util.Scanner;
public class SelectionSort {
    public static void main(String[] args) {
        //creating the instance of Scanner class
        Scanner input=new Scanner(System.in);
        //number of students's score to be stored
        int noOfStudents=input.nextInt();
        //array to store student score
        int score[]=new int[noOfStudents];
        //loop to take input marks from user
        for(int i=0;i<score.length;i++){
            score[i]=input.nextInt();
        }
        int n=score.length;
        //loop to sort the array using Selection sort
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(score[j]<score[min]){
                    min=j;
                }
                
            }
            //swap arr[i] with min score found
            int temp=score[min];
            score[min]=score[i];
            score[i]=temp;
        }
        //loop to print the sorted array
        for(int i=0;i<score.length;i++){
            System.out.print(score [i] +" ");
        }
        input.close();
    }
    
}