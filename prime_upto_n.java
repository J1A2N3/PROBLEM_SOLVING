package DSA_PRBLMS;
import java.util.Scanner;

public class prime_upto_n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many prime numbers you want: ");
        int n = sc.nextInt();
        int count = 0, num = 2;
        while (count < n) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
/*
Input: n = 5
Output: 2 3 5 7 11
🕒 Time: O(n * √p) (checking next n primes) | 🧠 Space: O(1)
(Note: p is the value of each prime being checked) ✅
*/