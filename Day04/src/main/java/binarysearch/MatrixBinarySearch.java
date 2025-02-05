package binarysearch;

public class MatrixBinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Check for empty matrix edge-case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        // Perform binary search on the virtual 1D array
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Convert 1D index to 2D indices
            int row = mid / cols;
            int col = mid % cols;
            int midElement = matrix[row][col];

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // Testing the method
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target1 = 3;
        int target2 = 13;

        System.out.println("Is target " + target1 + " found: " + searchMatrix(matrix, target1));
        System.out.println("Is target " + target2 + " found: " + searchMatrix(matrix, target2));
    }
}

