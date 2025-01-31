import java.util.Scanner;
public class CountingSort {
     public static void main(String[] args) {
        // creating an instance of scanner class
        Scanner input=new Scanner(System.in);
        //array to store ages
        int noOfStudents=input.nextInt();
        int ages[]=new int[noOfStudents];
        //taking input of students ranging from 10 to 18;
        for(int i=0;i<ages.length;i++){
            ages[i]=input.nextInt();
        }
        //frequnecy array to store frequency of each age
        int freq[]=new int[18+1];
        //traversing ages array and storing the frequency of ages in frequency array
        for(int i=0;i<ages.length;i++){
            freq[ages[i]]++;
        }
        //traversing frequency array 
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                System.out.print(i+ " ");
                freq[i]--;
            }
        }
        input.close();
    }
}
