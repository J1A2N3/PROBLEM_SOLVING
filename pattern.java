

package Core_Java;

public class Pattern {

	public static void main(String[] args) {
		int n=5,i,j,k,l;
	/*	*****
		*****
		*****
		*****
		*****	
		for(i=1;i<=n;i++) {
			for(j=1;j<=n;j++)
			{
					System.out.print("*");
			}
			System.out.println();	
		} 
		
		
		*
		**
		***
		****
		*****
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++)
			{
					System.out.print("*");
			}
			System.out.println();
			
		}    
		
		1
		12
		123
		1234
		12345
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++)
			{
					System.out.print(j);
			}
			System.out.println();
			
		}  
		
		1
		22
		333
		4444
		55555
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++)
			{
					System.out.print(i);
			}
			System.out.println();
			
		} 
		
		12345
		1234
		123
		12
		1
		for(i=1;i<=n;i++) {
			for(j=0;j<=n-i;j++)
			{
					System.out.print(j+1);
			}
			System.out.println();
			
		} 
		 
		
	     * 
	    * * 
	   * * * 
	  * * * * 
	 * * * * * 	
		for(i=1;i<=n;i++) {
			for(j=1;j<=n-i;j++)
			{
					System.out.print(" ");
			}
			for(k=1;k<=i;k++) {
			System.out.print("* ");
			}
			System.out.println();		
		} 
		
		
	     *
	    **
	   ***
	  ****
	 *****
		for(i=1;i<=n;i++) {
			for(j=1;j<=n-i;j++)
			{
					System.out.print(" ");
			}
			for(k=1;k<=i;k++) {
			System.out.print("*");
			}
			System.out.println();		
		}  
		
		
		*****
		 ****
		  ***
		   **
		    *
		for(i=1;i<=n;i++) {
			for(j=1;j<i;j++)
			{
					System.out.print(" ");
			}
			for(k=0;k<=n-i;k++) {
			System.out.print("*");
			}
			System.out.println();		
		} 
		
		
		* * * * * 
		 * * * * 
		  * * * 
		   * * 
		    * 
		for(i=1;i<=n;i++) {
			for(j=1;j<i;j++)
			{
					System.out.print(" ");
			}
			for(k=0;k<=n-i;k++) {
			System.out.print("* ");
			}
			System.out.println();		
		}  


		*****
		****
		***
		**
		*	
		for(i=1;i<=n;i++) {
			for(j=0;j<=n-i;j++)
			{
					System.out.print("*");
			}
			System.out.println();		
		}   
		
		
	     * 
	    * * 
	   * * * 
	  * * * * 
	 * * * * * 
	 * * * * * 
	  * * * * 
	   * * * 
	    * * 
	     * 	
		for(i=1;i<=n;i++) {
			for(j=1;j<=n-i;j++)
			{
					System.out.print(" ");
			}
			for(k=1;k<=i;k++) {
			System.out.print("* ");
			}
			System.out.println();		
		}  
		
		for(i=1;i<=n;i++) {
			for(j=1;j<i;j++) {
				System.out.print(" ");
			}
			for(k=0;k<=n-i;k++) {
				System.out.print("* ");

			}
			System.out.println();
		}   
		
		
	     *
	    **
	   ***
	  ****
	 *****
	 *****
	  ****
	   ***
	    **
	     *
		for(i=1;i<=n;i++) {
			for(j=1;j<=n-i;j++)
			{
					System.out.print(" ");
			}
			for(k=1;k<=i;k++) {
			System.out.print("*");
			}
			System.out.println();		
		}  
		
		for(i=1;i<=n;i++) {
			for(j=1;j<i;j++) {
				System.out.print(" ");
			}
			for(k=0;k<=n-i;k++) {
				System.out.print("*");

			}
			System.out.println();
		} 
		   
		   
		*
		**
		***
		****
		*****
		*****
		****
		***
		**
		*	
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++)
			{
					System.out.print("*");
			}	
			System.out.println();

		}  
		for(i=1;i<=n;i++) {
			for(j=0;j<=n-i;j++) {
				System.out.print("*");
			}
			System.out.println();

		}   
		
		
		0
		10
		010
		1010
		01010
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++) {
				System.out.print((i+j)%2);
			}
			System.out.println();

		}  
		
		
		1
		01
		101
		0101
		10101
		for(i=0;i<n;i++) {
			for(j=1;j<=i+1;j++) {
				System.out.print((i+j)%2);
			}
			System.out.println();

		}    
		
		
		1        1
		12      21
		123    321
		1234  4321     
		1234554321
		
		int spaces=2*(n-1);    //spaces in each row 
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++) {
				System.out.print(j);
			}
			for(k=1;k<=spaces;k++) {	
				System.out.print(" ");	
			}
			for(j=i;j>=1;j--) {
				System.out.print(j);
			}
			spaces-=2;
		System.out.println();
		}     
		
		1 
		2 3 
		4 5 6 
		7 8 9 10 
		11 12 13 14 15 	
		
		k=1;
		for(i=1;i<=n;i++) {
			for(j=1;j<=i;j++) {
				System.out.print(k+" ");
				k+=1;   
			}
		  System.out.println();
		}  

		
		A
		AB
		ABC
		ABCD
		ABCDE
				
		//method 1
		for(i=1;i<=n;i++) {
			int letter=65;
			for(j=1;j<=i;j++) {
				System.out.print((char)letter);
				letter+=1;
			}
			  System.out.println();
		}
		
		//method 2
		for (i = 1; i <= n; i++) {
            for (char ch = 'A'; ch < 'A' + i; ch++) {
                System.out.print(ch);
            }
            System.out.println(); 
        }
		 
		
		ABCDE
		ABCD
		ABC
		AB
		A	
		for(i=1;i<=n;i++) {
			for(char ch='A';ch<='A'+(n-i);ch++) {
                System.out.print(ch);
			}
            System.out.println(); 
		}	
		
		
		A
		BB
		CCC
		DDDD
		EEEEE
		for(i=0;i<n;i++) {
			int ch=65+i;
			for(j=1;j<=i+1;j++) {
	                System.out.print((char)ch);	
				}
	            System.out.println(); 
			}      
	
		
	     A
	    ABA
	   ABCBA
	  ABCDCBA
	 ABCDEDCBA
		for(i=0;i<n;i++) {
			for(j=1;j<n-i;j++) {
				System.out.print(" ");
			}
			for(char ch='A';ch<='A'+i;ch++) {
				System.out.print((char)ch);
			}
			for(k='A'+i-1;k>='A';k--) {
				System.out.print((char)k);
			}
           System.out.println(); 
		}  
		*/
		
		for(i=1;i<=n;i++) {
			int ch=n-i;
			for(int c=(65+ch);c<=65+n-1;c++) {
				System.out.print((char)c+" ");
			}
	           System.out.println(); 
		}   
	
		
		
	}
}
