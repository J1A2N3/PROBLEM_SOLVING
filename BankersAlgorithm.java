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