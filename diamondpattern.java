package DSA_PRBLMS;

public class diamondpattern {

	public static void main(String[] args) {
for(int i=1;i<=10;i++) {
	for(int j=1;j<=5;j++) {
		if(i<=5)
		{
			if(j<=5-i)
				System.out.print(" ");
			else
				System.out.print("* ");
		}
		else {
			if(j>=(i-5))
				System.out.print("* ");
			else
				System.out.print(" ");
		}
	}
	System.out.println();
}

	}

}
