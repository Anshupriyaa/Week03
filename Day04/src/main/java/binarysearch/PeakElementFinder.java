package binarysearch;

public class PeakElementFinder {
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return -1; //invalid output
        }
        if (n == 1) {
            return arr[0];
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check left neighbor; if mid is 0, consider left condition as true.
            boolean leftIsLower = (mid == 0) || (arr[mid] > arr[mid - 1]);
            // Check right neighbor; if mid is last index, consider right condition as true.
            boolean rightIsLower = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            // If both conditions are true, we found a peak.
            if (leftIsLower && rightIsLower) {
                return arr[mid];
            }

            // If left neighbor is greater, then there must be a peak on the left side.
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                // Else, move to the right side.
                left = mid + 1;
            }
        }
        return-1;
    }

    public static void main(String[] args) {
        // Example array (unsorted in a conventional sense but with the "peak" property)
        int[] arr = {1, 3, 20, 4, 1, 0};

        int peak = findPeakElement(arr);
        System.out.println("A peak element is: " + peak);
    }
}

