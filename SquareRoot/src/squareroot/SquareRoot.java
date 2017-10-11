package squareroot;

import java.util.*;
import java.math.*;

public class SquareRoot {

    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        
        System.out.print("Enter first length: ");
        a = getUserInput.nextInt();
        
        System.out.print("Enter second length: ");
        b = getUserInput.nextInt();
        
        System.out.print("Enter third length: ");
        c = getUserInput.nextInt();
        
        double pythagorean = (a*a) + (b*b) + (c*c);
        System.out.println("The area of the triangle is: " + Math.sqrt(pythagorean));
    }
    
}
