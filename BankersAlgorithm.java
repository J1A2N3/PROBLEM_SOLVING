<<<<<<< HEAD
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
=======
package DSA_PRBLMS;
import java.util.*;
class BankersAlgorithm{
	public static void main(String args[]) {
		int max[][]= {{4,2,6},{2,2,3},{9,0,1}};
		int[][] allocation= {{1,2,1},{1,2,1},{1,2,1}};
		int available[]= {4,3,9};
		int process=3;
		int resources=3;
		int need[][]=new int[process][resources];
		for(int i=0;i<process;i++) {
			for(int j=0;j<resources;j++) {
				need[i][j]=max[i][j]-allocation[i][j];
			}
		}
		int count=0;
		int work[]=Arrays.copyOf(available,3);
		boolean[] finish=new boolean[process];
		int safe[]=new int[process];
		
		while(count<process) {
			boolean found=false;
			for(int k=0;k<process;k++) {
				if(!finish[k]) {
					int i;
					for(i=0;i<resources;i++) {
						if(work[i]<need[k][i])
							break;
						}
					if(i==resources)
					{	for(int k1=0;k1<resources;k1++)
							work[k1]+=allocation[k][k1];
					}
					safe[count++]=k;
					finish[k]=true;
					found=true;
				}
			}
			if(!found)
				System.out.println("unsage state");
		}
		for (int i = 0; i<process; i++) {
            System.out.print("-> P" + safe[i]);
	}
}
}
>>>>>>> master
