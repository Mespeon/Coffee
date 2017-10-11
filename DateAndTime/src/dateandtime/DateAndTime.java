package dateandtime;

import java.util.*;

public class DateAndTime {
    
    public static Scanner getUserInput = new Scanner(System.in);

    public static void main(String[] args) {
        // Set date variables
            int day, month, year, second, minute, hour;
            String monthStr = "";
            GregorianCalendar dateNow = new GregorianCalendar();
        
        // Set array size
            int arraySize = 0;
            System.out.print("Enter number of candidates: ");
            arraySize = getUserInput.nextInt();
        
        // Create arrays
            String candidateList[] = new String[arraySize];
            int candidateVotes[] = new int[arraySize];
        
        // Get candidate names
            int inputLoop = 0;
            while (inputLoop < candidateList.length) {
                System.out.print("\nEnter name for candidate " + (inputLoop + 1) + ": ");
                candidateList[inputLoop] = getUserInput.next();
                System.out.print("Number of votes for " + candidateList[inputLoop] + ": ");
                candidateVotes[inputLoop] = getUserInput.nextInt();
                inputLoop++;
            }
        
        // Bubble Sorting
            int tempCount;
            String tempName;
            boolean goSwap = false;
            
            while (goSwap == false) {
                goSwap = true;
                
                // Swap Algorithm
                int swap = 0;
                while (swap < candidateList.length - 1) {
                    if (candidateVotes[swap] > candidateVotes[swap + 1]) {
                        tempCount = candidateVotes[swap + 1]; // GET VOTE COUNT IN SWAP INDEX
                        tempName = candidateList[swap + 1];  // GET CANDIDATE NAME IN SWAP INDEX
                        
                        // SWAP CURRENT VALUES WITH VALUES AT NEXT INDEX
                        candidateVotes[swap + 1] = candidateVotes[swap];
                        candidateList[swap + 1] = candidateList[swap];
                        
                        // SWAP NEXT VALUES IN CURRENT INDEX
                        candidateVotes[swap] = tempCount;
                        candidateList[swap] = tempName;
                        
                        // SET GO SWAP TO FALSE
                        goSwap = false;
                    }
                    swap++;
                }
            }
            
            System.out.print("\n\n");
            
        // Prepare for output
        // GET DATE TODAY
            day = dateNow.get(Calendar.DAY_OF_MONTH);
            month = dateNow.get(Calendar.MONTH);
            year = dateNow.get(Calendar.YEAR);
            // Generate a string version based on month number
            switch ((month + 1)) {
                case 1:
                    monthStr = "January";
                    break;
                    
                case 2:
                    monthStr = "February";
                    break;
                    
                case 3:
                    monthStr = "March";
                    break;
                    
                case 4:
                    monthStr = "April";
                    break;
                    
                case 5:
                    monthStr = "May";
                    break;
                    
                case 6:
                    monthStr = "June";
                    break;
                    
                case 7:
                    monthStr = "July";
                    break;
                    
                case 8:
                    monthStr = "August";
                    break;
                    
                case 9:
                    monthStr = "September";
                    break;
                    
                case 10:
                    monthStr = "October";
                    break;
                    
                case 11:
                    monthStr = "November";
                    break;
                    
                case 12:
                    monthStr = "December";
                    break;
            }
        
        // GET CURRENT TIME
            second = dateNow.get(Calendar.SECOND);
            minute = dateNow.get(Calendar.MINUTE);
            hour = dateNow.get(Calendar.HOUR);
            
        // Output everything
            System.out.println("Today is: " + monthStr + " " + day + ", " + year + "\n");
            System.out.println("The vote count is:");
            int x = candidateList.length - 1;
            while (x >= 0) {
                System.out.println(candidateList[x] + ": " + candidateVotes[x] + " votes");
                x--;
            }
            System.out.println("\nAs of: " + hour + ":" + minute + ":" + second);
            System.out.println("The candidate with the highest vote is: " + candidateList[candidateList.length - 1] + ", " + candidateVotes[candidateList.length - 1] + " votes");
    }
    
}
