package lowestnumber;

import java.util.*;

public class LowestNumber {
    
    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        int lowestNumber = 0;
        int numberSet[] = new int[5];
        int x = 0;
        int y = 0;
        
        while (x <= 4) {
            System.out.print("Enter number " + (x+1) +": ");
            numberSet[x] = getUserInput.nextInt();
            x++;
        }
        
        lowestNumber = numberSet[0];
        while (y <= 4) {
            if (numberSet[y] <= lowestNumber) {
                lowestNumber = numberSet[y];
            }
            y++;
        }
        
        System.out.println("The lowest number in the array is: " + lowestNumber);
    }
    
}
