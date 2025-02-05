package stringbuilderandstringbuffer;

public class ComparePerformance {
    //main method
    public static void main(String[] args) {
        int numConcatenations = 1_000_000;
        String appendStr = "hello";
        // Measuring time for StringBuffer
        StringBuffer stringBuffer= new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < numConcatenations; i++) {
            stringBuffer.append(appendStr);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        // Measuring time for StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < numConcatenations; i++) {
            stringBuilder.append(appendStr);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        //comparing the results of string buffer and string Builder

        if(durationBuffer<durationBuilder){
            System.out.println("StringBuffer is faster");
        }else{
            System.out.println("StringBuilder is faster");
        }

        // Output the time taken by both
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " nanoseconds");
    }
}

