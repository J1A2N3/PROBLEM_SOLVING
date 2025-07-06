package DSA_PRBLMS;
import java.util.*;

import java.util.*;

public class PrimeAdditionDivisible {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static int findLeastPrime(int[] arr1, int[] arr2) {
        int base = arr1[0];

        int lcmVal = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            lcmVal = lcm(lcmVal, arr2[i]);
        }

        int p = lcmVal - base;
        while (p < 1 || !isPrime(p)) {
            p += lcmVal;
        }

        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        System.out.println("Enter elements of arr1:");
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();

        System.out.println("Enter elements of arr2:");
        for (int i = 0; i < n; i++) arr2[i] = sc.nextInt();

        int result = findLeastPrime(arr1, arr2);
        System.out.println("Least Prime p: " + result);
        sc.close();
    }
}
/*
 * Input: arr1 = [5], arr2 = [2, 3, 5] → LCM = 30 → p = 25 (prime)
Output: Least Prime p: 25
🕒 Time: O(n * log Ai + k√p) | 🧠 Space: O(1)*/
