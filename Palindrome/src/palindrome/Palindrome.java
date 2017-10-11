package palindrome;

import java.util.*;

public class Palindrome {

    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Enter a string: ");
        String getString = getUserInput.next();
        String original = null;
        String reverse = null;
        
       // place characters in original arrangement in array
       char originalString[] = new char[getString.length()];
       int i = 0;
       while (i < getString.length()) {
           originalString[i] = getString.charAt(i);
           i++;
       }
       // convert array to string then place in a string variable
       original = Arrays.toString(originalString);
       System.out.println("ORIGINAL: " + original);
       
       /* read original string array backwards
          then place them in another array */
       char reverseString[] = new char[getString.length()];
       int f = getString.length() - 1;
       while (f >= 0) {
           reverseString[(originalString.length - f)-1] = originalString[f];
           /*
           code above will place the last index of the original string array
           in the first index of the reverse string array. for example:
           CONSIDER:
           alona
           getString.length = 5
           getString.length - 1 = 4 : originalString.length = 5 (0 ~ 4 = 5)
           f = 4
           
           ASSUME THAT:
           originalString[0] = a
           originalString[1] = l
           originalString[2] = o
           originalString[3] = n
           originalString[4] = a
           
           THEN:
           1. reverseString[(5 - 4) - 1] = originalString[4]
                = reverseString[0] = originalString[4] = a
           2. reverseString[(5 - 3) - 1] = originalString[3]
                = reverseString[1] = originalString[3] = n
           3. reverseString[(5 - 2) - 1] = originalString[2]
                = reverseString[2] = originalString[2] = o
           4. reverseString[(5 - 1) - 1] = originalString[1]
                = reverseString[3] = originalString[1] = l
           5. reverseString[(5 - 0) - 1] = originalString[0]
                = reverseString[4] = originalString[0] = a
           */
           f--;
       }
       // convert array to string then assign to string variable
       reverse = Arrays.toString(reverseString);
       System.out.println("REVERSED: " + reverse);
       
       // compare
       if (original.equals(reverse)) {
           System.out.println("The string is a palindrome.");
       }
       else {
           System.out.println("The string is not a palindrome.");
       }
    }
    
}
