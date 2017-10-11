package bubblesort;

import java.util.*;

public class BUbbleSort {

    public static void main(String[] args) {
        int arr[] = { 9, 5, 4, 1, 2};
        
        // BUBBLE SORTING
        //int temp;
        //boolean fixed = false;
        
        /*
        while (fixed == false) {
            fixed = true;
            
            // SWAP ALGORITHM
            for (int x = 0; x<arr.length-1; x++) {
                if (arr[x] > arr[x+1]) {
                    temp = arr[x+1];
                    arr[x+1] = arr[x];
                    arr[x] = temp;
                    fixed = false;
                }
            }
        }
        */
        
        /* MAKESHIFT REVERSE SORT
        Arrays.sort(arr);
        
        for (int s = arr.length-1; s >= 0; s--) {
            System.out.println(arr[s]);
        }
        */
        
        ///* STRING TO ARRAY AND SORTING
        String b = "The Clear Blue Sky";
        char a[] = new char[b.length()];
        
        for (int x = 0; x < a.length; x++) {
            a[x] = b.charAt(x);
        }
        
        Arrays.sort(a);
        for (int s = a.length-1; s >= 0; s--) {
            System.out.print(a[s]);
        }
        //*/
        
    }
    
}
