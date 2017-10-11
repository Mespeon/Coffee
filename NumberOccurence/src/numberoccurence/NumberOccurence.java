package numberoccurence;

import java.util.*;

public class NumberOccurence {

    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        int paper[] = new int[5];
        int checkNumber = 0;
        int x = 0;
        int y = 0;
        int s = 0;
        
        while (x <= 4) {
            System.out.print("Enter number " + (x+1) + ": ");
            paper[x] = getUserInput.nextInt();
            
            x++;
        }
        
        System.out.print("Enter number to be checked: ");
        checkNumber = getUserInput.nextInt();
        
        while (y <= 4) {
            if (paper[y] == checkNumber) {
                s+=1;
            }
            
            y++;
        }
        
        System.out.println("\nThe number " + checkNumber + " appeared " + s + " times.");
    }
    
}
