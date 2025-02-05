import linearsearch.SearchNegativeNumber;
import linearsearch.SearchSpecificWord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearSearchTesting {
    @Test
    void f1(){
        SearchNegativeNumber number=new SearchNegativeNumber();
        int[] array={1,2,-3,4,5,-6};
        assertEquals(2,number.findNegative(array));
    }
    @Test
    void f2(){
        SearchSpecificWord word=new SearchSpecificWord();
        String[] sentence={"anshu is a good girl","anshu loves watching telivision"};
        String words="good";
        assertEquals("anshu is a good girl",word.searchWord(sentence,words));
    }

}
