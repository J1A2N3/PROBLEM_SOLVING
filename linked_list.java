package DSA_PRBLMS;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}
public class linked_list {
	Node head;
	
public void addlast(int data) {
	Node newnode=new Node(data);
	if(head==null)
		{
		head=newnode;
		return ;
		}
	Node temp=head;
	while(temp.next!=null) {
		temp=temp.next;
	}
	temp.next=newnode;
}

public void printlist() {
	Node temp=head;
	while(temp!=null) {
		System.out.print(temp.data+"->");
		temp=temp.next;
	}
	System.out.println("null");
}

public void addfirst(int data) {
	Node newnode=new Node(data);
	newnode.next=head;
	head=newnode;
	
}

public void deletefirst() {
	if(head==null)
		{System.out.println("nothing to delete");
			return;
		}
	int deleted=head.data;
	head=head.next;
	System.out.println("deleted"+deleted);
	
}

public void deletelast() {
	if(head==null)
		{
		System.out.println("nothing to remove");
		return;
		}
	if(head.next==null)
		{head=null;
			return;
		}
	Node temp=head;
	while(temp.next.next!=null) {
		temp=temp.next;
	}
	temp.next=null;
}

public void deletebyvalue(int data) {
	Node temp=head;
	if(head==null)
		System.out.println("nothing to delete");
	if(temp.data==data)
		{deletefirst();
			return;
		}
	while(temp.next!=null)
	{
		if(temp.next.data==data)
		{temp.next=temp.next.next;
			return;
		}
		temp=temp.next;
	}
	System.out.println("nothing to found");
		
}

public int findlength() {
	Node temp=head;
	int len=0;
	while(temp!=null)
	{	
		len++;
		temp=temp.next;
	}
	return len;
}

public  void insertbypos(int pos,int data) {
	Node temp=head;
	Node newnode=new Node(data);
	if (pos <= 0) {
        System.out.println("Invalid position");
        return;
    }
	if (pos == 1) {
        newnode.next = head;
        head = newnode;
        return;
    }
	if(findlength()+1<pos)
	{
		System.out.println("position not found");
		return;
	}
	for(int i=1;i<pos-1;i++) 
		temp=temp.next;
	
	newnode.next=temp.next;
	temp.next=newnode;
}

public void search(int data) {
	Node temp=head;
	int count=1;
	while(temp.next!=null) {
		if(temp.data==data)
			{System.out.print(temp.data+"found in index"+count);
				return;
			}
		count++;
		temp=temp.next;
	}
	System.out.println("not found");
}
public int getkthpos(int k) {
	Node temp=head;
	if(head==null)
	{	System.out.println("empty list");
		return -1;
	}
	int length=findlength();
	if(k>length || k<=0)
	{	System.out.println("invalid index");
		return -1;
	}
	for(int i=1;i<k;i++)
		temp=temp.next;
	return temp.data;
}
public void reverselinkedlist() {
	Node temp=head;
	Node next=null;
	Node prev=null;
	while(temp!=null) {
		next=temp.next;
		temp.next=prev;
		prev=temp;
		temp=next;
	}
	head=prev;
}

public int findmiddleelement() {
	Node slow = head;   
    Node fast = head;   
    // the Tortoise and Hare algorithm.
    while (fast != null && fast.next != null && slow != null) {
        fast = fast.next.next;  
        slow = slow.next;        
    }
    return slow.data;  
}

	public static void main(String[] args) {
		linked_list ll= new linked_list();
		ll.addlast(11);
		ll.addlast(22);
		ll.addlast(33);
		ll.addlast(44);
		ll.addlast(55);
		ll.addfirst(66);
		ll.printlist();
		
		ll.deletelast();
		ll.deletefirst();
		ll.deletebyvalue(44);
		ll.printlist();
		
		int mid=ll.findmiddleelement();
		System.out.println("middle element"+mid);
		ll.insertbypos(1, 77);
		int k=ll.getkthpos(3);
		System.out.println("kth pos"+k);
		ll.search(77);
		int len=ll.findlength();
		System.out.println(len);
		ll.printlist();
		ll.reverselinkedlist();	
		ll.printlist();
	}
}
