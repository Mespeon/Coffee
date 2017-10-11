package sampleloop;

public class SampleLoop {

    public static void main(String[] args) {
        int lineCount = 0;
        int x = 1000;
        
        /* LINEAR LOOP */
        /*
        while (looper <= 1000) {
            System.out.println(lineCount + " ");
            lineCount++;
            
            System.out.println(looper + "\n");
            looper+=2;
        }
        */
        
        /* LOGARITHMIC LOOP */
        while (x > 1) {
            //x/=2;
            System.out.println(x + "\n");
        }
        
    }   
}
