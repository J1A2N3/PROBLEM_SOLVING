<<<<<<< HEAD
package DSA_PRBLMS;

public class kadnes_algorithm {
	public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]); // Take max of new start vs extend
            maxSum = Math.max(maxSum, currSum); // Update max
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
    }
}
/*
 Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6
 Time & Space Complexity
Time: O(n)

Space: O(1)
 */
=======
package DSA_PRBLMS;

public class kadnes_algorithm {
	public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]); // Take max of new start vs extend
            maxSum = Math.max(maxSum, currSum); // Update max
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
    }
}
/*
 Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6
 Time & Space Complexity
Time: O(n)

Space: O(1)
 */
>>>>>>> master
