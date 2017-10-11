package multiplier;

import java.util.*;

public class Multiplier {

    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        int [] multiplier = new int[6];
        
        for (int x = 1; x < multiplier.length; x++) {
            multiplier[x] = (x*4)*x;
            System.out.println(multiplier[x]);
        }
    }
    
}
