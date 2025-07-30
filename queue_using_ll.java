package DSA_PRBLMS;

public class queue_using_ll {
	private node front,rear;
	private static class node{
		int data;
		node next;
		node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public queue_using_ll(){
		this.front=this.rear=null;
	}
	
	void enqueue(int data) {
		node newnode=new node(data);
		if(rear==null)
			front=rear=newnode;
		rear.next=newnode;
		newnode=rear;
	}
	
	int pop() {
		if(front==null)
			return -1;		
		int data= front.data;
		front=front.next;
		if(front==null)
			rear=null;
		return data;
	}
	
	
	int peek() {
		if(front==null)
			return -1;
		return front.data;
	}
}

