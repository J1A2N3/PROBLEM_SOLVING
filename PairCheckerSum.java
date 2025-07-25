package DSA_PRBLMS;

import java.util.*;

public class PairCheckerSum {
	public static boolean hasPairWithSum(int[] A, int x) {
        Set<Integer> seen = new HashSet<>();
        for (int num : A) {
            int complement = x - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }
            seen.add(num);
        }

        return false;
    }
    public static void main(String[] args) {
        int[] A = {10, 15, 3, 7};
        int x = 17;

        if (hasPairWithSum(A, x)) {
            System.out.println(" Pair exists.");
        } else {
            System.out.println(" No such pair.");
        }
    }
}
/*
 
  Time Complexity: O(n)
🚀 Space Complexity: O(n)

Input: A = [10, 15, 3, 7], x = 17
putput: true or false
*/