import binarysearch.FindFirstAndLastOccurrence;
import binarysearch.MatrixBinarySearch;
import binarysearch.PeakElementFinder;
import binarysearch.RotationPointFinder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BinarySearchTesting {
    @Test
    void f1(){
        FindFirstAndLastOccurrence firstOccurrence=new FindFirstAndLastOccurrence();
        int array[]={1,2,3,5,5,7,7,7};

        assertEquals(7,firstOccurrence.findLastOccurrence(array,7,0,array.length-1));
        assertEquals(5,firstOccurrence.findFirstOccurrence(array,7,0,array.length-1));
    }
    @Test
    void f2(){
        MatrixBinarySearch m1=new MatrixBinarySearch();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        assertEquals(true,m1.searchMatrix(matrix,3));
    }
    @Test
    void f3(){
        RotationPointFinder rotation=new RotationPointFinder();
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        assertEquals(4,rotation.findRotationPoint(arr));
    }
    @Test
    void f4() {
        PeakElementFinder element = new PeakElementFinder();
        int array[] = {1, 3, 20, 4, 1, 0};
        assertEquals(20, element.findPeakElement(array));
    }
}
