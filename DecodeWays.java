package DSA_PRBLMS;
public class DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int prev = 1; 
        int curr = 1; 
        for (int i = 1; i < n; i++) {
            int temp = 0;
            // Check single digit valid code
            if (s.charAt(i) != '0') {
                temp += curr;
            }
            // Check if two digits form a valid code
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                temp += prev;
            }
            // Shift the window
            prev = curr;
            curr = temp;
        }
        return curr;
    }
    public static void main(String[] args) {
        String input = "226";
        int result = numDecodings(input);
        System.out.println("Number of ways to decode \"" + input + "\": " + result);
    }
}
/*
Input	"226"
Output	Integer — 3
Time Complexity	O(n)
Space Complexity	O(1)
*/
