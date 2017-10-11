package arraystoreexceptions;

import java.io.*;

public class ArrayStoreExceptions {

    public static void main(String args[]) throws IOException {
        
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[5];
        int i, x;
        String str = null;
        
        System.out.println("Enter five numbers: ");
        for (i = 0; i <= 4; i++) {
            str = userInput.readLine();
            
            try {
                arr[i] = Integer.parseInt(str);
            }
        
            catch (NumberFormatException e) {
                System.out.println("Wrong data type entered. Try again.");
                i--;
                continue;
            }
        }
        
        System.out.println("Numbers entered are: ");
        x = 0;
        while (true) {
            try {
                System.out.println(arr[x]);
                x++;
            }
            
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Numbers are over: " + e);
                return;
            }
        }
    }
    
}
