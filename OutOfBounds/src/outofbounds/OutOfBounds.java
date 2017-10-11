package outofbounds;

import java.util.*;

public class OutOfBounds {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        int numberArray[] = new int[5];
        int arraySize = 5;
        int x = 0;
        int y = 0;
        
        System.out.print("\nYou actual array size is: 5\n\n");
        
        do {
            System.out.print("Enter value for index " + x + ": ");
            numberArray[x] = userInput.nextInt();
            
            x++;
        }
        while (x < arraySize);
        
        System.out.println("\nArray has been successfully populated.");
        System.out.print("Select an index to display its value: ");
        y = userInput.nextInt();
        
        try {
            System.out.println("Index " + y + " is: " + numberArray[y]);
        }
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The array index you specified is out of bounds. \n Error message: " + e); 
        }
        
    }
}
