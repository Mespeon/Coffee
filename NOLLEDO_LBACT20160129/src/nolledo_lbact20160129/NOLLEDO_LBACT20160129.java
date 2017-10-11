package nolledo_lbact20160129;

import java.util.*;

public class NOLLEDO_LBACT20160129 {

    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        int numberSet[] = new int[10];
        int functionSelect = 0;
        int evenCount = 0;
        int oddCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;
        int s = 0;
        int a = 0;
        int r = numberSet.length - 1;
        int m = 0;
        int p = 0;
        
        // GET USER INPUT
        while (s < numberSet.length) {
            System.out.print("Enter number " + (s+1) + ": ");
            numberSet[s] = getUserInput.nextInt();
            s++;
        }
        
        // DISPLAY MENU
        System.out.println("\nPlease select from one of the following options:");
        System.out.println("[ 1 ] Sort \n[ 2 ] Count Odd/Even \n[ 3 ] Count Positive/Negative \n[ 4 ] Do all of the above");
        System.out.print("Function: ");
        functionSelect = getUserInput.nextInt();
        
        // SWITCH NOW
        switch (functionSelect) {
            case 1:
                // SORT
                Arrays.sort(numberSet);
                
                // DISPLAY ASC
                System.out.println("Array sorted ascending: ");
                while (a < numberSet.length) {
                    System.out.println(numberSet[a]);
                    a++;
                }
            
                // DISPLAY DESC
                System.out.println("\nArray sorted descending: ");
                while (r >= 0) {
                    System.out.println(numberSet[r]);
                    r--;
                }
            
            break;
            
            case 2:
                // LOOP THROUGH THE ARRAY
                while (m < numberSet.length) {
                    if (numberSet[m] % 2 == 0) {
                        evenCount += 1;
                    }
                    
                    else {
                        oddCount += 1;
                    }
                    m++;
                }
                
                System.out.println("\nThere are " + evenCount + " even numbers and " + oddCount + " odd numbers.");
                
            break;
                
            case 3:
                // LOOP THROUGH THE ARRAY
                while (p < numberSet.length) {
                    if (numberSet[p] >= 0) {
                        positiveCount += 1;
                    }
                    
                    else {
                        negativeCount += 1;
                    }
                    p++;
                }
                
                System.out.println("\nThere are " + positiveCount + " positive numbers and " + negativeCount + " negative numbers.");
                
            break;
                    
            case 4:
                // SORT
                Arrays.sort(numberSet);
                
                // DISPLAY ASC
                System.out.println("Array sorted ascending: ");
                while (a < numberSet.length) {
                    System.out.println(numberSet[a]);
                    a++;
                }
            
                // DISPLAY DESC
                System.out.println("\nArray sorted descending: ");
                while (r >= 0) {
                    System.out.println(numberSet[r]);
                    r--;
                }
                
                 // LOOP THROUGH THE ARRAY
                while (m < numberSet.length) {
                    if (numberSet[m] % 2 == 0) {
                        evenCount += 1;
                    }
                    
                    else {
                        oddCount += 1;
                    }
                    m++;
                }
                
                System.out.println("\nThere are " + evenCount + " even numbers and " + oddCount + " odd numbers.");
                
                // LOOP THROUGH THE ARRAY
                while (p < numberSet.length) {
                    if (numberSet[p] >= 0) {
                        positiveCount += 1;
                    }
                    
                    else {
                        negativeCount += 1;
                    }
                    p++;
                }
                
                System.out.println("\nThere are " + positiveCount + " positive numbers and " + negativeCount + " negative numbers.");
                
            break;
                
            default:
                System.out.println("Invalid input. Nothing will be performed.");
        }
    }
    
}
