package DSA_PRBLMS;
public class stack_using_ll {
	private node top;
	private static class node{
		int data;
		node next;
		node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public stack_using_ll(){
		this.top=null;
	}
	
	int push(int data) {
		node newnode=new node(data);
		newnode.next=top;
		top=newnode;
		return 0;
	}
	
	int pop() {
		if(top==null)
			return -1;		
		else
			{top=top.next;
			return top.data;}				
	}
	
	
	int peek() {
		return top.data;
	}
}
