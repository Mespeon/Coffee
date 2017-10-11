package votecounttype2;

import java.util.*;

public class VoteCountType2 {

    public static void main(String[] args) {
        String candidates[][] = new String[10][10];
        
        candidates[0][0] = "NyanCat";
        candidates[0][1] = "200";
        
        candidates[1][0] = "Shinya";
        candidates[1][1] = "100";
        
        candidates[2][0] = "LingTositeSigure";
        candidates[2][1] = "90";
        
        // BEFORE SORT
        System.out.print(candidates[0][0]);
        System.out.print(candidates[0][1]);
        
        System.out.print(candidates[1][0]);
        System.out.print(candidates[1][1]);
        
        System.out.print(candidates[2][0]);
        System.out.print(candidates[2][1]);
    }
    
}
