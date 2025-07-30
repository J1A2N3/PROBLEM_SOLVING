<<<<<<< HEAD
package DSA_PRBLMS;
import java.util.*;
public class WordBreakDFS {
	    public static boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> wordSet = new HashSet<>(wordDict);
	        Map<String, Boolean> memo = new HashMap<>();
	        return canBreak(s, wordSet, memo);
	    }
	    private static boolean canBreak(String s, Set<String> wordSet, Map<String, Boolean> memo) {
	        if (s.isEmpty()) return true;
	        if (memo.containsKey(s)) return memo.get(s);
	        for (int i = 1; i <= s.length(); i++) {
	            String prefix = s.substring(0, i);
	            if (wordSet.contains(prefix) && canBreak(s.substring(i), wordSet, memo)) {
	                memo.put(s, true);
	                return true;
	            }
	        }
	        memo.put(s, false);
	        return false;
	    }
	    public static void main(String[] args) {
	        String s = "applepenapple";
	        List<String> wordDict = Arrays.asList("apple", "pen");
	        System.out.println("Can be segmented: " + wordBreak(s, wordDict));
	    }
	}
/*Input:
s = "catsanddog"
wordDict = ["cat","cats","and","sand","dog"]

Output:
true

Time & Space
Time: O(n²) 

Space: O(n) 
*/

=======
package DSA_PRBLMS;
import java.util.*;
public class WordBreakDFS {
	    public static boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> wordSet = new HashSet<>(wordDict);
	        Map<String, Boolean> memo = new HashMap<>();
	        return canBreak(s, wordSet, memo);
	    }
	    private static boolean canBreak(String s, Set<String> wordSet, Map<String, Boolean> memo) {
	        if (s.isEmpty()) return true;
	        if (memo.containsKey(s)) return memo.get(s);
	        for (int i = 1; i <= s.length(); i++) {
	            String prefix = s.substring(0, i);
	            if (wordSet.contains(prefix) && canBreak(s.substring(i), wordSet, memo)) {
	                memo.put(s, true);
	                return true;
	            }
	        }
	        memo.put(s, false);
	        return false;
	    }
	    public static void main(String[] args) {
	        String s = "applepenapple";
	        List<String> wordDict = Arrays.asList("apple", "pen");
	        System.out.println("Can be segmented: " + wordBreak(s, wordDict));
	    }
	}
/*Input:
s = "catsanddog"
wordDict = ["cat","cats","and","sand","dog"]

Output:
true

Time & Space
Time: O(n²) 

Space: O(n) 
*/

>>>>>>> master
