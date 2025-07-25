package DSA_PRBLMS;
public class MissingNumber {
	 public static int findMissing(int[] nums) {
	        int n = nums.length;
	        int total = n * (n + 1) / 2;
	        int sum = 0;
	        for (int i = 0; i < n; i++) {
	            sum += nums[i];
	        }
	        return total - sum;
	    }
	    public static void main(String[] args) {
	        int[] nums = {3, 0, 1};
	        System.out.println("Missing Number is: " + findMissing(nums)); 
	    }
}
/*
 Input/Output:
makefile
Copy
Edit
Input: [3, 0, 1]
Output: 2
⏱ Time & Space:
Time: O(n)

Space: O(1)
*/