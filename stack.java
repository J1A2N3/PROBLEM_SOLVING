package DSA_PRBLMS;

public class stack {
	static int top;
	static int stack_[];
	static int capacity;
	
	 stack(int capacity){
		 top=-1;
		 stack_=new int[capacity];
	     stack.capacity = capacity;
	}
	
	 int push(int element) {
		if(top<capacity-1)
		{	
		stack_[++top]=element;
		return 0;
		}
		else
			return -1;
	}
	 int pop() {
		 if(top==-1)
			 return -1;
		 else 
			 return stack_[top--];
		 
	}
	 int peek() {
		 if(top==-1)
			 return -1;
		 else
			 return stack_[top];
	}
		   
}
