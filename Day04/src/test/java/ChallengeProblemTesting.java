import challengeproblem.ChallengeProblem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChallengeProblemTesting {
    @Test
    void f1(){
        ChallengeProblem problems=new ChallengeProblem();
        int[] arr = {3,2, 4, -1,0, 1};
        int target=4;
        assertEquals(5,problems.findFirstMissingPositive(arr));
        assertEquals(5,problems.binarySearch(arr,target));
    }
}
