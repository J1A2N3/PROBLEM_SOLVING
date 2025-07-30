package DSA_PRBLMS;

public class Queue {
	int front,rear,size,queue[];
	
	public Queue(int capacity){
		int front=0;
		int rear=0;
		int size=0;
		queue=new int[capacity];
	}
	
	public void enqueue(int val) {
		if(queue.length==size)
			{
			System.out.println("queue filled");
			}
		else {
			queue[rear]=val;
			rear=(rear+1)%queue.length;
			size++;
		}
	}
	
	public int dequeue() {
		if(size==0) {
			System.out.println("queue isempty");
			return -1;
		}
		else {
			int val=queue[front];
			front=(front+1)%queue.length;
			size--;
			return val;
		}
		
	}
	
	public int peek() {
        if (size==queue.length) return -1;
        return queue[front];
    }
	
	public void printQueue() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index]+" ");
        }
        System.out.println();
    }
	
}
