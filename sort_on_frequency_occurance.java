package DSA_PRBLMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class sort_on_frequency_occurance {
	
	public List<Integer> sortByFreq(int[] arr) {
		
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int num : arr) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    List<Integer> list = new ArrayList<>();
    for (int num : arr) list.add(num);

    Collections.sort(list, (a, b) -> {
        if (!freq.get(a).equals(freq.get(b))) {
            return freq.get(b) - freq.get(a); 
        } else {
            return a - b;
        }
    });

    return list;
}

	public static void main(String[] args) {
		sort_on_frequency_occurance obj = new sort_on_frequency_occurance();
        int[] arr = {4, 5, 6, 5, 4, 3};
        System.out.println("Sorted by frequency: " + obj.sortByFreq(arr));
	}
}
/*
🔷 Sample Input & Output:
Test Case 1
Input:
arr = [4, 5, 6, 5, 4, 3]

Output:
[4, 4, 5, 5, 3, 6]

Test Case 2
Input:
arr = [1, 2, 2, 3, 1, 2]

Output:
[2, 2, 2, 1, 1, 3]

Test Case 3
Input:
arr = [9, 8, 9, 8, 7, 7]

Output:
[7, 7, 8, 8, 9, 9]

Test Case 4
Input:
arr = [10, 20, 30]

Output:
[10, 20, 30]

⏱️ Time Complexity:
Building frequency map: O(n)

Sorting with custom comparator: O(n log n)

Overall: O(n log n)

✅ Space: O(n) for map + list

*/