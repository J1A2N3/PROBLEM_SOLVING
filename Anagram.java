<<<<<<< HEAD
package DSA_PRBLMS;

public class Anagram {
	    public static boolean isAnagram(String s1, String s2) {
	        if (s1.length() != s2.length()) return false;
	        int[] freq = new int[26];
	        for (int i = 0; i < s1.length(); i++) {
	            freq[s1.charAt(i) - 'a']++;
	        }
	        for (int i = 0; i < s2.length(); i++) {
	            freq[s2.charAt(i) - 'a']--;
	        }
	        for (int count : freq) {
	            if (count != 0) return false;
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        String s1 = "listen";
	        String s2 = "silent";

	        if (isAnagram(s1, s2))
	            System.out.println("Yes, it's an Anagram");
	        else
	            System.out.println("Nope, not an Anagram");
	    }
	}
/*
  Input/Output:
vbnet
Copy
Edit
Input: "listen", "silent"
Output: Anagram? true
⏱ Time & Space:
Time: O(n)

Space: O(1)
 */
=======
package DSA_PRBLMS;

public class Anagram {
	    public static boolean isAnagram(String s1, String s2) {
	        if (s1.length() != s2.length()) return false;
	        int[] freq = new int[26];
	        for (int i = 0; i < s1.length(); i++) {
	            freq[s1.charAt(i) - 'a']++;
	        }
	        for (int i = 0; i < s2.length(); i++) {
	            freq[s2.charAt(i) - 'a']--;
	        }
	        for (int count : freq) {
	            if (count != 0) return false;
	        }

	        return true;
	    }

	    public static void main(String[] args) {
	        String s1 = "listen";
	        String s2 = "silent";

	        if (isAnagram(s1, s2))
	            System.out.println("Yes, it's an Anagram");
	        else
	            System.out.println("Nope, not an Anagram");
	    }
	}
/*
  Input/Output:
vbnet
Copy
Edit
Input: "listen", "silent"
Output: Anagram? true
⏱ Time & Space:
Time: O(n)

Space: O(1)
 */
>>>>>>> master
