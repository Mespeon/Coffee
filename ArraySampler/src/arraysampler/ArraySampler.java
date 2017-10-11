package arraysampler;

import java.util.*;

public class ArraySampler {
    
    public static Scanner ScanUserInput = new Scanner(System.in);

    public static void main(String[] args) {
        String[] contacts = new String[10];
        
        for (int a = 0; a < contacts.length; a++) {
            System.out.print("Enter a name: ");
            contacts[a] = ScanUserInput.next();
        }
        
        System.out.println("\n---------------------------------");
        System.out.println("|  A VERY COMPACT CONTACTS LIST |");
        System.out.println("---------------------------------\n");
        for (int i = 0; i < contacts.length; i++) {
            System.out.println("Contact " + (i+1) + " is: " + contacts[i]);
        }
    }
    
}
