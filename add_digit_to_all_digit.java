<<<<<<< HEAD
package DSA_PRBLMS;

public class add_digit_to_all_digit {
	public static void main(String[] args) {
			int add=4;
			int digit=234;
			int finalize=0;
			int multiplier=1;
			while(digit>0) {
			int rem=digit%10;
			int value=rem+add;
			finalize=finalize+(value*multiplier);
			multiplier*=10;
			digit/=10;
			}
			System.out.println(finalize);
	}
}
/* input:234
 * output: 678
 * tc:size of digit
 * sc:1
 * */
=======
package DSA_PRBLMS;

public class add_digit_to_all_digit {
	public static void main(String[] args) {
			int add=4;
			int digit=234;
			int finalize=0;
			int multiplier=1;
			while(digit>0) {
			int rem=digit%10;
			int value=rem+add;
			finalize=finalize+(value*multiplier);
			multiplier*=10;
			digit/=10;
			}
			System.out.println(finalize);
	}
}
/* input:234
 * output: 678
 * tc:size of digit
 * sc:1
 * */
>>>>>>> master
