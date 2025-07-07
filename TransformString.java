package DSA_PRBLMS;
// reomve duplicates
public class TransformString {
	    public static String removeDuplicates(String s) {
	        boolean[] seen = new boolean[256]; // For all ASCII characters
	        StringBuilder result = new StringBuilder();

	        for (int i = 0; i < s.length(); i++) {
	            char ch = s.charAt(i);
	            if (!seen[ch]) {
	                seen[ch] = true;
	                result.append(ch);
	            }
	        }

	        return result.toString();
	    }

	    public static void main(String[] args) {
	        String input = "aabbcc";
	        System.out.println("Transformed: " + removeDuplicates(input)); 
	    }
	}
/*
Input/Output:
vbnet
Copy
Edit
Input: "aabbcc"
Output: "abc"
⏱ Time & Space:
Time: O(n)
Space: O(1)
*/