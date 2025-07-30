package DSA_PRBLMS;
import java.util.Arrays;
public class next_largest_element_key_stack {
	public static void main(String[] args) {
		int n=5;
		stack s=new stack(n);
		int arr[]= {1,4,6,9,2};
		int ans[]= new int[n];
		for(int i=n-1;i>=0;i--) {
		while(s.top!=-1 && arr[i]>=s.stack_[s.top]) {
			//put lesserthan symbol if finding next smallest elementN
			 s.pop();
		}
		if(s.top==-1)
			ans[i]=-1;
		else
			ans[i]=s.peek();
		
	s.push(arr[i]);	
	}
		System.out.println(Arrays.toString(ans));
}
}