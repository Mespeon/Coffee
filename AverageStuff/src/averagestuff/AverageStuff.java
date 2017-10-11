package averagestuff;

import java.util.*;

public class AverageStuff {
    
    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[][]average = new int[3][6];
        String[]names = new String[3];
        int filler = 0;
        
        System.out.println("This program will calculate the average of 3 students.\n\n");
        System.out.println("For starters, please enter the names of the three students: ");
        for (int i = 0; i < 3; i++){
            names[i] = getUserInput.next();
        }
        
        System.out.println("\nYou entered the following names: ");
        for (int x = 0; x < 3; x++) {
            System.out.println(names[x]);
        }
        
        System.out.println("\n");
        
        while (filler < 3) {
            System.out.println("\n\nEnter five grades for " + names[filler]);
                for (int s = 0; s < 5; s++) {
                    average[filler][s] = getUserInput.nextInt();
                }
                
        filler++;
        }
        
        System.out.print("\n\nThe average grade of Student " + names[0] + " is: ");
        for (int y = 0; y < 5; y++) {
            average[0][5]+=average[0][y];
        }
        System.out.print(average[0][5]/=5);
        
        System.out.print("\n\nThe average grade of Student " + names[1] + " is: ");
        for (int z = 0; z < 5; z++) {
            average[1][5]+=average[1][z];
        }
        System.out.print(average[1][5]/=5);
        
        System.out.print("\n\nThe average grade of Student " + names[2] + " is: ");
        for (int g = 0; g < 5; g++) {
            average[2][5]+=average[2][g];
        }
        System.out.print(average[2][5]/=5);
        
        System.out.println("\n\n");
    }
    
}
