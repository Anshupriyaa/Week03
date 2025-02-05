import org.junit.jupiter.api.Test;
import stringbuilderandstringbuffer.ConcatenateStrings;
import stringbuilderandstringbuffer.RemoveDuplicate;
import stringbuilderandstringbuffer.ReverseString;

import static org.junit.jupiter.api.Assertions.*;

public class StringBuilderTesting {
    @Test
    void f1(){
        ConcatenateStrings str=new ConcatenateStrings();
        String[] strings={"anshu","nimish","silky","mohan","apple"};
        assertEquals("anshu nimish silky mohan apple ",str.concatenate(strings));
    }
    @Test
    void f2(){
        RemoveDuplicate str=new RemoveDuplicate();
        String a="aannsshhuu";
        assertEquals("anshu",str.modifyString(a));
    }
    @Test
    void f3(){
        ReverseString a=new ReverseString();
        String b="anshu";
        assertEquals("uhsna",a.reverseString(b));
    }
}
