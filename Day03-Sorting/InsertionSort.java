import java.util.Scanner;
public class InsertionSort {
    public static void main(String[] args) {
        //creating the instance of Scanner class
        Scanner input=new Scanner(System.in);
        //number of Employee's Id to be sorted
        int noOfEmployee=input.nextInt();
        //array to store Employee id
        int empId[]=new int[noOfEmployee];
        //loop to take input marks from user
        for(int i=0;i<empId.length;i++){
            empId[i]=input.nextInt();
        }
        int n=empId.length;
        //loop to sort the array using Insertion sort
        for(int i=1;i<n;i++){
            int min=empId[i];
            int j=i-1;
            while(j>=0 && min<empId[j] ){
                empId[j+1]=empId[j];
                j--;
            }
            empId[j+1]=min;

        }
       
        //loop to print the sorted array
        for(int i=0;i<empId.length;i++){
            System.out.print(empId [i] +" ");
        }
        input.close();
    }
    
}
