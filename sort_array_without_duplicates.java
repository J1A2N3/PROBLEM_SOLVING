<<<<<<< HEAD
package DSA_PRBLMS;
import java.util.Arrays;

public class sort_array_without_duplicates {
	    public static void main(String[] args) {
	        int[] arr = {4, 2, 7, 4, 7, 9, 2, 1};
	        Arrays.sort(arr); // O(n log n)

	        System.out.print(arr[0] + " "); // Print first element

	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] != arr[i - 1]) {
	                System.out.print(arr[i] + " ");
	            }
	        }
	    }
	}

=======
package DSA_PRBLMS;
import java.util.Arrays;

public class sort_array_without_duplicates {
	    public static void main(String[] args) {
	        int[] arr = {4, 2, 7, 4, 7, 9, 2, 1};
	        Arrays.sort(arr); // O(n log n)

	        System.out.print(arr[0] + " "); // Print first element

	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] != arr[i - 1]) {
	                System.out.print(arr[i] + " ");
	            }
	        }
	    }
	}

>>>>>>> master
