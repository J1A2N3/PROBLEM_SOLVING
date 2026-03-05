public class Main
{
    static int length(int n){
	        int c=n;
	        int count=0;
	        while(c>0){
	            count++;
	            c/=10;
	        }
	        return count;
	    }
	   
	  static int power(int base,int length){
	      int num=1;
	      while(length>0){
	          num*=base;
	          length--;
	      }
	      return num;
	  }
	   static boolean armstrong(int n){
	       int original=n;
	       int add=0;
	       int len=Main.length(n);
	       while(n>0){
	        int rem=n%10;
	         add=add+power(rem,len);
	         n/=10;
	    }
	    return add==original;
	   }
	public static void main(String[] args) {
	    
	    int number = 173;
        boolean ans = armstrong(number);
        System.out.println(ans); 
	    	}
}
