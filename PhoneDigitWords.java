<<<<<<< HEAD
package DSA_PRBLMS;
import java.util.*;
public class PhoneDigitWords {
    static String[] keypad = {
        "",     
        "",   
        "abc", 
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs", 
        "tuv",  
        "wxyz" 
    };
    public static void main(String[] args) {
        String digits = "23";
        List<String> result = new ArrayList<>();   
        if (digits == null || digits.length() == 0) {
            System.out.println("No combinations.");
            return;
        }
        generateWords(digits, 0, "", result);
        System.out.println("Possible words: " + result);
    }
    static void generateWords(String digits, int index, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String options = keypad[digit - '0'];
        for (int i = 0; i < options.length(); i++) {
            generateWords(digits, index + 1, current + options.charAt(i), result);
        }
    }
}
/*
 * WORKING OF RECURSION:
 * generateWords("23", 0, ""):
    digit = '2' → "abc"
    → generateWords(1, "a")
    → generateWords(1, "b")
    → generateWords(1, "c")

generateWords("23", 1, "a"):
    digit = '3' → "def"
    → generateWords(2, "ad")  added
    → generateWords(2, "ae")  added
    → generateWords(2, "af")  added

generateWords("23", 1, "b"):
    → generateWords(2, "bd") 
    → generateWords(2, "be") 
    → generateWords(2, "bf") 

generateWords("23", 1, "c"):
    → generateWords(2, "cd") 
    → generateWords(2, "ce") 
    → generateWords(2, "cf")
    
input: 23    
output:[ad, ae, af, bd, be, bf, cd, ce, cf]
Time Complexity = O(kⁿ × n)
space Complexity = O(kⁿ × n)
*/
=======
package DSA_PRBLMS;
import java.util.*;
public class PhoneDigitWords {
    static String[] keypad = {
        "",     
        "",   
        "abc", 
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs", 
        "tuv",  
        "wxyz" 
    };
    public static void main(String[] args) {
        String digits = "23";
        List<String> result = new ArrayList<>();   
        if (digits == null || digits.length() == 0) {
            System.out.println("No combinations.");
            return;
        }
        generateWords(digits, 0, "", result);
        System.out.println("Possible words: " + result);
    }
    static void generateWords(String digits, int index, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String options = keypad[digit - '0'];
        for (int i = 0; i < options.length(); i++) {
            generateWords(digits, index + 1, current + options.charAt(i), result);
        }
    }
}
/*
 * WORKING OF RECURSION:
 * generateWords("23", 0, ""):
    digit = '2' → "abc"
    → generateWords(1, "a")
    → generateWords(1, "b")
    → generateWords(1, "c")

generateWords("23", 1, "a"):
    digit = '3' → "def"
    → generateWords(2, "ad")  added
    → generateWords(2, "ae")  added
    → generateWords(2, "af")  added

generateWords("23", 1, "b"):
    → generateWords(2, "bd") 
    → generateWords(2, "be") 
    → generateWords(2, "bf") 

generateWords("23", 1, "c"):
    → generateWords(2, "cd") 
    → generateWords(2, "ce") 
    → generateWords(2, "cf")
    
input: 23    
output:[ad, ae, af, bd, be, bf, cd, ce, cf]
Time Complexity = O(kⁿ × n)
space Complexity = O(kⁿ × n)
*/
>>>>>>> master
