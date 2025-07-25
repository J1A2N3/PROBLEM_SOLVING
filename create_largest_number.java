package DSA_PRBLMS;
import java.util.*;

public class create_largest_number {
	    public static void main(String[] args) {
	        Integer[] arr = {3, 30, 34, 5, 9};
	        Arrays.sort(arr, (a, b) -> (b + "" + a).compareTo(a + "" + b));
	        StringBuilder sb = new StringBuilder();
	        for (int num : arr) sb.append(num);
	        System.out.println(sb.toString());
	    }
	}

/* input:{3, 30, 34, 5, 9}
output: 9533430
tc:O(nlogn + n)
sc:o(n)
*/