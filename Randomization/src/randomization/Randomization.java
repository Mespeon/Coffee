package randomization;

import java.util.Random;

public class Randomization {
    
    public Random randNumber = new Random();
    public int generatedNumber = 0;
    public static int numberSet[] = new int[5];
    public int indexPosition = 0;
    
    public void GenerateRandomNumber() {
        // Generate a random number
        generatedNumber = randNumber.nextInt(50);
        CheckRandomNumber();
    }
    
    public void CheckRandomNumber() {
        if (indexPosition == 0) {
            // Write the first generated number into the array
            WriteRandomNumber();
            
            // Increment index position by 1
            indexPosition += 1;
        }
        
        else {
            // Check if the first number is odd or even.
            if (numberSet[0] % 2 == 0) {
                // If the first number is even ...
                if (generatedNumber % 2 == 0) {
                    WriteRandomNumber();    // Call the Write method
                    indexPosition += 1;     // Increment position by 1
                }
                
                else {
                    GenerateRandomNumber(); // If the number is not even, generate again. 
                }
            }
            
            if (numberSet[0] % 2 > 0) {
                // If the first number is odd ...
                if (generatedNumber % 2 > 0) {
                    WriteRandomNumber();    // Call the Write method
                    indexPosition += 1;     // Increment position by 1
                }
                
                else {
                    GenerateRandomNumber(); // If the number is not odd, generate again.
                }
            }
        }
    }
    
    public void WriteRandomNumber() {
        numberSet[indexPosition] = generatedNumber;
    }

    public static void main(String[] args) {
        Randomization callOut = new Randomization();
        
        int s = 0;
        while (s < numberSet.length) {
            callOut.GenerateRandomNumber();
            s++;
        }
        
        int a = 0;
        while (a < numberSet.length) {
            System.out.println(numberSet[a]);
            a++;
        }
    } 
}
