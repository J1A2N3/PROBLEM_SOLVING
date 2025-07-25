package DSA_PRBLMS;

import java.util.Arrays;

public class CompressAndDoubleOneLoop {
	/* Problem Statement:
		 You are given an array A[] of size n. You need to:

		 Traverse the array from left to right.

		 If A[i] is the same as A[i+1], then:

		 Double the value of A[i] → A[i] = 2*A[i]

		 Replace A[i+1] with 0

		 After applying the rule once, shift all non-zero elements to the left (like compression).

		 Keep the size of array same. */
	 public static void modifyArray(int[] A) {
	        int n = A.length;
	        int index = 0; 

	        for (int i = 0; i < n; i++) {
	            if (A[i] == 0) continue;

	            if (i + 1 < n && A[i] == A[i + 1]) {
	                A[index++] = 2 * A[i];
	                i++; 
	            } else {
	                A[index++] = A[i];
	            }
	        }
	        while (index < n) {
	            A[index++] = 0;
	        }
	        System.out.println("Modified array: " + Arrays.toString(A));
	    }

	    public static void main(String[] args) {
	        int[] A = {2, 2, 0, 4, 4, 8};
	        modifyArray(A);
	    }
}

/*
 * Time & Space Complexity
Time: O(n) ✅

Space: O(1) ✅ (in-place)

*/
