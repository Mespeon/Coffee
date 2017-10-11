package votecount;

import java.util.*;

public class VoteCount {

    public static Scanner getUserInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Set array size
            int arraySize = 0;
            System.out.print("Enter number of candidates: ");
            arraySize = getUserInput.nextInt();
        
        // Create arrays
            String candidateList[] = new String[arraySize];
            int candidateVotes[] = new int[arraySize];
        
        System.out.print("\n\n");
        
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
        
        System.out.println("\n\n");
        
        // Output array
            System.out.println("Current Vote Count");
            int x = candidateList.length - 1;
            while (x >= 0) {
                System.out.println(candidateList[x] + ": " + candidateVotes[x] + " votes");
                x--;
            }
    }
}
