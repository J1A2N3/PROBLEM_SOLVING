<<<<<<< HEAD
package DSA_PRBLMS;
import java.util.Stack;
public class DecodeString {
	public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) k = k * 10 + (ch - '0');
            else if (ch == '[') {
                count.push(k); result.push(res); k = 0; res = "";
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int times = count.pop();
                while (times-- > 0) temp.append(res);
                res = temp.toString();
            } else res += ch;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));  // Output: accaccacc
    }
}
/*EXPLAINATION OF QUESTION:
 You are given an encoded string where:
A number is followed by a substring inside square brackets
The substring should be repeated that many times
Input: "3[a]2[bc]"
Output: "aaabcbc"
Time	O(n)
Space	O(n)*/
=======
package DSA_PRBLMS;
import java.util.Stack;
public class DecodeString {
	public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) k = k * 10 + (ch - '0');
            else if (ch == '[') {
                count.push(k); result.push(res); k = 0; res = "";
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int times = count.pop();
                while (times-- > 0) temp.append(res);
                res = temp.toString();
            } else res += ch;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));  // Output: accaccacc
    }
}
/*EXPLAINATION OF QUESTION:
 You are given an encoded string where:
A number is followed by a substring inside square brackets
The substring should be repeated that many times
Input: "3[a]2[bc]"
Output: "aaabcbc"
Time	O(n)
Space	O(n)*/
>>>>>>> master
