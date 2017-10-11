package instant;

import java.util.*;

public class Instant {

    public static Scanner getUserInput = new Scanner(System.in);
    public int numberSet[] = new int[10];
    
    /*
    public void insertValues(int value) {
        numberSet[indexPosition] = value;
        indexPosition++;
    }
    
    public void displayValues() {
        int arraySize = 0;
        while (arraySize < indexPosition) {
            System.out.println(numberSet[arraySize]);
            arraySize++;
        }
    }
    */
    
    public void initialize() {
         // GET VALUES
        int s = 0;
        while (s < numberSet.length) {
            System.out.print("Enter number " + (s+1) + ": ");
            numberSet[s] = getUserInput.nextInt();
            s++;
        }
        showMenu();
    }
    
    public void showMenu() {
        // SHOW MENU
        int functionSelect = 0;
        System.out.println("\nPlease select from one of the following options: ");
        System.out.println("[ 1 ] Sort \n[ 2 ] Count Odd/Even \n[ 3 ] Count Positive/Negative \n[ 4 ] Do all of the above \n[ 5 ] Exit the program");
        System.out.print("Enter function: ");
        functionSelect = getUserInput.nextInt();
        
        switch (functionSelect) {
            case 1:
                sortOrder();
                showMenu();
                break;
                
            case 2:
                countOE();
                showMenu();
                break;
                
            case 3:
                countPN();
                showMenu();
                break;
                
            case 4:
                sortOrder();
                countOE();
                countPN();
                showMenu();
                break;
                
            case 5:
                break;
                
            default:
                System.out.println("\n\nInvalid function. Please try again.");
                showMenu();
        }
    }
    
    public void sortOrder() {
        int a = 0;
        int r = numberSet.length - 1;
        // SORT
        Arrays.sort(numberSet);
                
        // DISPLAY ASC
        System.out.println("\nArray sorted ascending: ");
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
        
    }
    
    public void countOE() {
        int evenCount = 0;
        int oddCount = 0;
        int m = 0;
        
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
        
    }
    
    public void countPN() {
        int positiveCount = 0;
        int negativeCount = 0;
        int p = 0;
        
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
        
    }
    
    public static void main(String[] args) {
        /*
        Instant startProgramSequence = new Instant();
        
        startProgramSequence.insertValues(10);
        startProgramSequence.insertValues(4);
        startProgramSequence.insertValues(20);
        startProgramSequence.insertValues(999);
        
        startProgramSequence.displayValues();
        */
        
        Instant startSequence = new Instant();
        
        startSequence.initialize();
    }
    
}
