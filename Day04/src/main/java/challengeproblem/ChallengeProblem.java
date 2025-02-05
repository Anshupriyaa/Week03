package challengeproblem;

import java.util.Arrays;
public class ChallengeProblem{
    // Function to find the first missing positive integer.
    public static int findFirstMissingPositive(int[] arr) {
        //loop to find the largest element in the array
        int largest=0;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(arr[i],largest);
        }
        //creating the new array of size(largest+1) to handle 0 case
        int present[]=new int[largest+1];
        //iterating over the arr array to mark the frequency of each element in the present array
        for(int i=0;i<arr.length;i++){
            //ignoring the case if negative integer encounters
            if(arr[i]<0){
                continue;
            }
            present[arr[i]]++;
        }
        //iterating over the present array to check if any element frequency is zero or not
        //if zero ? return that element
        for(int i=0;i<present.length;i++){
            if(present[i]==0){
                return i;
            }

        }
        //in case no element is found missing ..the largest+1 is the positive missing number
        return largest+1;
    }

    // Function to perform Binary Search and return the index of target
    public static int binarySearch(int[] arr, int target) {
        //as binary search works on sorted array
        //we will sort the array
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //return invalid index if target not found
        return -1;
    }
    //main method
    public static void main(String[] args) {
        //initializing an array
        int[] arr = {3,2, 4, -1,0, 1};
        //initializing the variable target to check if the element is present or not
        int target = 4;
        int missingNumber = findFirstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missingNumber);
        int targetIndex = binarySearch(arr, target);
        System.out.println("Index of " + target + " (after sorting): " + targetIndex);
    }
}

