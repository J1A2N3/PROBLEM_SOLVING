<<<<<<< HEAD
package DSA_PRBLMS;

import java.util.Arrays;

public class OddAscEvenDescSorter {
    public static void sortOddsAscEvensDesc(int[] arr) {
	 int n = arr.length;
     int[] odds = new int[n];
     int[] evens = new int[n];
     int o = 0, e = 0;

     // Separate odds and evens
     for (int num : arr) {
         if (num % 2 == 0)
             evens[e++] = num;
         else
             odds[o++] = num;
     }

     // Sort odds ascending
     Arrays.sort(odds, 0, o);

     // Sort evens ascending then reverse for descending
     Arrays.sort(evens, 0, e);
     for (int i = 0; i < e / 2; i++) {
         int temp = evens[i];
         evens[i] = evens[e - 1 - i];
         evens[e - 1 - i] = temp;
     }

     // Rebuild the original array
     int idx = 0;
	for (int i1 = 0; i1 < o; i1++) arr[idx++] = odds[i1];
     for (int i1 = 0; i1 < e; i1++) arr[idx++] = evens[i1];
    }
 public static void main(String[] args) {
     int[] arr = {5, 3, 2, 8, 1, 4};
     sortOddsAscEvensDesc(arr);
     System.out.println("Sorted array: " + Arrays.toString(arr));
 }

}
=======
package DSA_PRBLMS;

import java.util.Arrays;

public class OddAscEvenDescSorter {
    public static void sortOddsAscEvensDesc(int[] arr) {
	 int n = arr.length;
     int[] odds = new int[n];
     int[] evens = new int[n];
     int o = 0, e = 0;

     // Separate odds and evens
     for (int num : arr) {
         if (num % 2 == 0)
             evens[e++] = num;
         else
             odds[o++] = num;
     }

     // Sort odds ascending
     Arrays.sort(odds, 0, o);

     // Sort evens ascending then reverse for descending
     Arrays.sort(evens, 0, e);
     for (int i = 0; i < e / 2; i++) {
         int temp = evens[i];
         evens[i] = evens[e - 1 - i];
         evens[e - 1 - i] = temp;
     }

     // Rebuild the original array
     int idx = 0;
	for (int i1 = 0; i1 < o; i1++) arr[idx++] = odds[i1];
     for (int i1 = 0; i1 < e; i1++) arr[idx++] = evens[i1];
    }
 public static void main(String[] args) {
     int[] arr = {5, 3, 2, 8, 1, 4};
     sortOddsAscEvensDesc(arr);
     System.out.println("Sorted array: " + Arrays.toString(arr));
 }

}
>>>>>>> master
