package DSA_PRBLMS;
import java.util.*;
public class BankersAlgorithm {
    static int numberOfProcesses = 5; 
    static int numberOfResources = 3;
    // Allocation Matrix
    static int[][] allocation = {
        {0, 1, 0},
        {2, 0, 0},
        {3, 0, 2},
        {2, 1, 1},
        {0, 0, 2}
    };
    // Max Matrix
    static int[][] max = {
        {7, 5, 3},
        {3, 2, 2},
        {9, 0, 2},
        {4, 2, 2},
        {5, 3, 3}
    };
    // Available Resources
    static int[] available = {3, 3, 2};
    public static void main(String[] args) {
        int[][] need = new int[numberOfProcesses][numberOfResources];
        // Step 1: Calculate Need Matrix = Max - Allocation
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = 0; j < numberOfResources; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
        boolean[] finished = new boolean[numberOfProcesses];
        int[] safeSequence = new int[numberOfProcesses];
        int[] work = Arrays.copyOf(available, numberOfResources);
        int count = 0;
        while (count < numberOfProcesses) {
            boolean found = false;
            for (int i = 0; i < numberOfProcesses; i++) {
                if (!finished[i]) {
                    int j;
                    for (j = 0; j < numberOfResources; j++) {
                        if (need[i][j] > work[j]) {
                            break;
                        }
                    }
                    if (j == numberOfResources) {
                        for (int k = 0; k < numberOfResources; k++) {
                            work[k] += allocation[i][k];
                        }
                        safeSequence[count++] = i;
                        finished[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("System is in UNSAFE state. No safe sequence.");
                return;
            }
        }
        // If all processes can finish
        System.out.print("System is in SAFE state.\nSafe Sequence: ");
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.print("P" + safeSequence[i]);
            if (i != numberOfProcesses - 1) System.out.print("->");
        }
    }
}
