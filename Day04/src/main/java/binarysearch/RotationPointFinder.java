package binarysearch;

public class RotationPointFinder {
    ///method to find rotation point
    public static int findRotationPoint(int[] arr) {
        //binary search
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        //initializing an array to find rotation point
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        //storing the index of rotation point and then printing the smmalest element
        int rotationPointIndex = findRotationPoint(arr);
        System.out.println("The rotation point is at index: " + rotationPointIndex);
        System.out.println("The smallest element is: " + arr[rotationPointIndex]);
    }
}
