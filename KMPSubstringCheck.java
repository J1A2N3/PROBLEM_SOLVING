<<<<<<< HEAD
package DSA_PRBLMS;
	import java.util.Scanner;
	public class KMPSubstringCheck {

	    // Build LPS array
	    public static int[] buildLPS(String pattern) {
	        int[] lps = new int[pattern.length()];
	        int len = 0; // length of previous longest prefix suffix

	        for (int i = 1; i < pattern.length(); ) {
	            if (pattern.charAt(i) == pattern.charAt(len)) {
	                len++;
	                lps[i] = len;
	                i++;
	            } else {
	                if (len != 0) {
	                    len = lps[len - 1]; // fallback
	                } else {
	                    lps[i] = 0;
	                    i++;
	                }
	            }
	        }
	        return lps;
	    }

	    // KMP algorithm
	    public static boolean isSubstring(String text, String pattern) {
	        int[] lps = buildLPS(pattern);
	        int i = 0, j = 0; // i for text, j for pattern

	        while (i < text.length()) {
	            if (text.charAt(i) == pattern.charAt(j)) {
	                i++;
	                j++;
	            }

	            if (j == pattern.length()) {
	                return true; // match found
	            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
	                if (j != 0)
	                    j = lps[j - 1];
	                else
	                    i++;
	            }
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first string: ");
	        String str1 = sc.nextLine();

	        System.out.print("Enter second string: ");
	        String str2 = sc.nextLine();

	        boolean result = isSubstring(str1, str2);
	        System.out.println(result);

	        sc.close();
	    }
	}

/*
	✅ Test Case:
	Input:
	str1 = "abcxabcdabxabcdabcdabcy"
	str2 = "abcdabcy"
	Output: true

	🕒 Time: O(n + m) | 🧠 Space: O(m)
	where n = str1.length() and m = str2.length() (due to LPS array) ✅
=======
package DSA_PRBLMS;
	import java.util.Scanner;
	public class KMPSubstringCheck {

	    // Build LPS array
	    public static int[] buildLPS(String pattern) {
	        int[] lps = new int[pattern.length()];
	        int len = 0; // length of previous longest prefix suffix

	        for (int i = 1; i < pattern.length(); ) {
	            if (pattern.charAt(i) == pattern.charAt(len)) {
	                len++;
	                lps[i] = len;
	                i++;
	            } else {
	                if (len != 0) {
	                    len = lps[len - 1]; // fallback
	                } else {
	                    lps[i] = 0;
	                    i++;
	                }
	            }
	        }
	        return lps;
	    }

	    // KMP algorithm
	    public static boolean isSubstring(String text, String pattern) {
	        int[] lps = buildLPS(pattern);
	        int i = 0, j = 0; // i for text, j for pattern

	        while (i < text.length()) {
	            if (text.charAt(i) == pattern.charAt(j)) {
	                i++;
	                j++;
	            }

	            if (j == pattern.length()) {
	                return true; // match found
	            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
	                if (j != 0)
	                    j = lps[j - 1];
	                else
	                    i++;
	            }
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first string: ");
	        String str1 = sc.nextLine();

	        System.out.print("Enter second string: ");
	        String str2 = sc.nextLine();

	        boolean result = isSubstring(str1, str2);
	        System.out.println(result);

	        sc.close();
	    }
	}

/*
	✅ Test Case:
	Input:
	str1 = "abcxabcdabxabcdabcdabcy"
	str2 = "abcdabcy"
	Output: true

	🕒 Time: O(n + m) | 🧠 Space: O(m)
	where n = str1.length() and m = str2.length() (due to LPS array) ✅
>>>>>>> master
	*/