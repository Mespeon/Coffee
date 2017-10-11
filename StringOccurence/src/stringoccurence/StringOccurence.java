package stringoccurence;

import java.util.*;

public class StringOccurence {

    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        String dictionary[] = new String[5];
        String checkString = null;
        int x = 0;
        int y = 0;
        int s = 0;
        
        while (x <= 4) {
            System.out.print("Enter string/character " + (x+1) + ": ");
            dictionary[x] = getUserInput.next();
            
            x++;
        }
        
        System.out.print("Enter string/character to be checked: ");
        checkString = getUserInput.next();
        
        while (y <= 4) {
            if (dictionary[y].equals(checkString)) {
                s+=1;
            }
            
            y++;
        }
        
        System.out.println("\nThe string/character " + checkString + " appeared " + s + " times.");
    }
    
}
