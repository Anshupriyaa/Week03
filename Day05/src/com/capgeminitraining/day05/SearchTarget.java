package com.capgeminitraining.day05;

import java.util.Scanner;
import java.util.Arrays;
public class SearchTarget {
    //method of linear search to check whether the element in the array occurs or not
    public static int linearSearch(int arr[],int target){
        long startTime=System.nanoTime();
        long endTime;
        long totalDuration;
        //loop to traverse the array
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        endTime=System.nanoTime();
        totalDuration=endTime-startTime;
        return -1;
    }
    //method to find element using binary search
    public static int binarySearch(int arr[],int target,int start,int end){
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]<target) {
                start=mid +1;
            }else{
                end=mid-1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean input= true;
        while(input){
            System.out.println("Enter the size of the array");
            int size=sc.nextInt();
            int arr[]=new int[size];
            //loop to take array input
            System.out.println("Enter the element in the array");
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println("Enter the element you want to search ");
            //taking input from the user the element to be search
            int target=sc.nextInt();
            //storing the time taken by linear and binary search to find the target
            // Linear Search
            long startTime = System.nanoTime();
            linearSearch(arr,target);
            long totalTimeByLinearSearch=System.nanoTime()-startTime;
            Arrays.sort(arr);
            startTime = System.nanoTime();
            binarySearch(arr,target,0,arr.length-1);
            long totalTimeByBinarySearch=System.nanoTime()-startTime;

            if(totalTimeByBinarySearch<totalTimeByLinearSearch){
                System.out.println("Binary search is faster");
            }else{
                System.out.println("Linear search is faster");
            }
            System.out.println("Write true if you want to compare for more arrays otherwise false");
            input=sc.nextBoolean();
        }
        sc.close();

    }
}

