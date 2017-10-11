package set2_activity;

import java.util.*;

public class Set2_Activity {
    
    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        // NUMBER 1
        /*
        int numberSet[] = new int[10];
        int evenCount = 0;
        int oddCount = 0;
        int s = 0;
        int a = 0;
        
        while (a < numberSet.length) {
            System.out.print("Enter number " + (a+1) + ": ");
            numberSet[a] = getUserInput.nextInt();
            a++;
        }
        
        while (s < numberSet.length) {
            if (numberSet[s]%2 == 0) {
                evenCount += 1;
            }
            
            else {
                oddCount += 1;
            }
            s++;
        }
        
        System.out.println("\nThe number of even numbers are: " + evenCount);
        System.out.println("The number of odd numbers are: " + oddCount);
        */
        
        // NUMBER 2
        /*
        String input = "";
        int s = 0;
        int a = 0;
                
        System.out.print("Enter string: ");
        input = getUserInput.next();
        
        char characterSet[] = new char[input.length()];
        while (s < characterSet.length) {
            characterSet[s] = input.charAt(s);
            s++;
        }
        
        Arrays.sort(characterSet);
        while (a < characterSet.length) {
            System.out.println(characterSet[a]);
            a++;
        }
        */
        
        // NUMBER 3
        int arraySize = 0;
        int s = 0;
        int a = 0;
        int r = 0;
        int m = 0;
        int middleIndex = 0;
        
        System.out.println("Enter number of input: ");
        arraySize = getUserInput.nextInt();
    }
    
}
