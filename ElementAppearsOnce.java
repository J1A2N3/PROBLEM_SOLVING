package DSA_PRBLMS;

public class ElementAppearsOnce {
	 public static int findSingleElement(int[] nums) {
	        int result = 0;

	        for (int num : nums) {
	            result ^= num; // XOR cancels out duplicates
	        }

	        return result;
	    }
	    public static void main(String[] args) {

	 int[] nums = {4, 2, 2, 3, 1, 1, 4 };

     int unique = findSingleElement(nums);
     System.out.println("Element that appears once: " + unique);
	    }
}
/* if element doesnt appear twice the nuse map to find frequency
if (entry.getValue() == 1) {
return entry.getKey();

Example Input & Output
Input:  {2, 3, 5, 2, 3, 6, 5}
Output: Element that appears once: 6
⏱ Time and Space Complexity
Time: O(n)
Space: O(n) — due to HashMap

*/