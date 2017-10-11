/*
Arithmetic Exception Handling
in a Simple Calculator Program

Used previous Basic Calculator Program
then reworked the code to add ArithmeticException

Author: Mark Nolledo, BSCOS201
*/

package basiccalculator;

import java.util.Scanner;

public class BasicCalculator {
    static private int firstNum;
    static private int secondNum;
    static private int result;
    static private String operator;
    
    public float compute() {
        switch (operator) {
            case "A":
            case "a":
                result = firstNum + secondNum;
                break;
            
            case "S":
            case "s":
                result = firstNum - secondNum;
                break;
                
            case "M":
            case "m":
                result = firstNum * secondNum;
                break;
                
            case "D":
            case "d":
                try {
                    result = firstNum / secondNum;
                }
            
                catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero. \n Error message: " + e);
                }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        BasicCalculator lockOn = new BasicCalculator();
        
        System.out.print("Enter first number: ");
        firstNum = userInput.nextInt();
        
        System.out.print("Enter second number: ");
        secondNum = userInput.nextInt();
        
        System.out.print("[ a ] ADD \n[ s ] SUBTRACT \n[ m ] MULTIPLY \n[ d ] DIVIDE");
        System.out.print("\nEnter operator: ");
        operator = userInput.next();
        
        System.out.println("The result of your calculation is: " + lockOn.compute());
    }
    
}
