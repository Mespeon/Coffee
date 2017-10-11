package salarycalculator;

import java.util.*;

public class SalaryCalculator {
    
    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Get number of entries
        int x = 0;
        System.out.print("Enter number of entries: ");
        x = getUserInput.nextInt();
        
        // Create arrays using index value
        String employeeName[] = new String[x];
        String employeeNumber[] = new String[x];
        int employeeManhour[] = new int[x];
        int employeeSalary[] = new int[x];
        int salrate = 200;   // salary rate
        
        // Ask for employee detail input
        // This will include auto formatting the number with 1001 onwards
        int s = 0;
        while (s < x) {
            // Show a formatted output for the employee number
            String numberFormat = "";
            if (s < 9) {
                numberFormat = "100" + (s + 1);
            }
            
            else {
                numberFormat = "10" + (s + 1);
            }
            
            System.out.println("\nEmployee Number " + numberFormat);  // Output the employee number
            employeeNumber[s] = numberFormat;   // Push the value into the array
            System.out.print("Name: ");     // Get user input
            employeeName[s] = getUserInput.next();  // Push value into array
            System.out.print("Manhour: ");  // Get current employee manhour
            employeeManhour[s] = getUserInput.nextInt();    // Push the value into the array
            employeeSalary[s] = employeeManhour[s] * salrate;
            s++;
        }
        
        System.out.println("\nUNSORTED");
        // Show unsorted array
        int a = 0;
        while (a < x) {
            System.out.println(employeeNumber[a] + " " + employeeName[a] + " " + employeeManhour[a]);
            a++;
        }
        
        System.out.println("\nUNSORTED WITH SALARY");
        // Show unsorted array with salary
        int g = 0;
        while (g < x) {
            System.out.println(employeeNumber[g] + " " + employeeName[g] + " " + employeeManhour[g] + " " + employeeSalary[g]);
            g++;
        }
        
        // BUBBLE SORTING
        String tempName;    // temp for name
        String tempNumber;  // temp for employee number
        int tempManhour;    // temp for manhour
        int tempSalary;     // temp for salary
        
        boolean goSwap = false; // will tell if a swap is needed or not
        
        // Begin sorting
        while (goSwap == false) {
            goSwap = true;
            
            // Swap Algorithm
            int swapList = 0;
            while (swapList < x - 1) {
                if (employeeSalary[swapList] > employeeSalary[swapList + 1]) {
                    tempName = employeeName[swapList + 1];          // get next name
                    tempNumber = employeeNumber[swapList +1];       // get next number
                    tempManhour = employeeManhour[swapList + 1];    // get next manhour
                    tempSalary = employeeSalary[swapList + 1];      // get next salary
                    
                    // SWAP CURRENT VALUES WITH NEXT INDEX
                    employeeName[swapList + 1] = employeeName[swapList];
                    employeeNumber[swapList + 1] = employeeNumber[swapList];
                    employeeManhour[swapList + 1] = employeeManhour[swapList];
                    employeeSalary[swapList + 1] = employeeSalary[swapList];
                    
                    // SWAP NEXT VALUES IN CURRENT INDEX
                    employeeName[swapList] = tempName;
                    employeeNumber[swapList] = tempNumber;
                    employeeManhour[swapList] = tempManhour;
                    employeeSalary[swapList] = tempSalary;
                    
                    // Set goSwap to false
                    goSwap = false;
                }
                swapList++;
            }
        }
        
        System.out.println("\nSORTED WITH SALARY");
        // Show sorted array with salary
        int l = x - 1;
        while (l >= 0) {
            System.out.println(employeeNumber[l] + " " + employeeName[l] + " " + employeeManhour[l] + " " + employeeSalary[l]);
            l--;
        }
    }
    
}
