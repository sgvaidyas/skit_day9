package day9;

import java.util.Scanner;

class Node
{
	int data;
	Node next;
}

class SLL
{
	public Node head;
	int count;
	public SLL() {
		head = null;
		count=0;
	}
	public Node createNode(int ele)
	{
		Node temp = new Node();
		temp.data = ele;
		temp.next =null;
		count++;
		return temp;
	}
	public void insertend(int ele)
	{
		Node newnode = createNode(ele);
		if(head==null)
			head = newnode;
		else
		{
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newnode;
		}			
	}
	public void insertbegin(int ele)
	{
		Node newnode = createNode(ele);
		if(head==null)
			head = newnode;
		else
		{
			newnode.next = head;
			head = newnode;
		}
	}
	public void deletebeg()
	{
		if(head==null)
			System.out.println("List empty");
		else
		{
			System.out.println("Deleting ..." + head.data);
			head=head.next;
			count--;
		}
		
	}
	public void deleteend()
	{
		if(head==null)
			System.out.println("List empty");
		else
		{
			Node pp,cp;
			pp=cp=head;
			while(cp.next!=null)
			{
				pp = cp;
				cp = cp.next;
			}
			System.out.println("Deletimg.... " + cp.data);
			
			if(pp==cp)
				head=null;
			else
			{
				cp=null;
				pp.next = null;
			}
			count--;
		}
	}
	
	public void insertpos(int pos,int ele)
	{
		if(pos==1)
			insertbegin(ele);
		else if(pos== count+1)
			insertend(ele);
		else
		{
			Node newnode = createNode(ele);
			Node pp,cp;
			pp=cp=head;
			for(int i=1;i<pos;i++)
			{
				pp= cp;
				cp=cp.next;
			}
			pp.next=newnode;
			newnode.next=cp;
		}
	}
	public void deletepos(int pos)
	{
		if(pos==1)
			deletebeg();
		else if(pos== count)
			deleteend();
		else
		{
			Node pp,cp;
			pp=cp=head;
			for(int i=1;i<pos;i++)
			{
				pp= cp;
				cp=cp.next;
			}
			pp.next = cp.next;
			System.out.println("deleting....."+ cp.data);
			cp=null;
			count--;
		}
	}	
	
	public void display()
	{
		
		if(head==null)
			System.out.println("no elements in List");
		else
		{
			System.out.println("List elements are=");
			Node temp=head;
			while(temp!=null)
			{
				System.out.println(temp.data);
				temp=temp.next;
			}
		}
			
	}
}

public class SingleLinkedlist {

	public static void main(String[] args) {
		SLL st = new SLL();
		Scanner ob = new Scanner(System.in);
		int ch,ele=0,pos;
		do
		{
			System.out.println("1 Insert begin");
			System.out.println("2 Insert end");
			System.out.println("3 Insert pos");
			System.out.println("4 Delete begin");
			System.out.println("5 Delete end");
			System.out.println("6 Delete pos");
			System.out.println("7 Display");
			System.out.println("8 EXIT");			
			ch=ob.nextInt();
			if(ch>=1 && ch<=3)
			{
				System.out.println("Enter element = ");
				ele=ob.nextInt();
			}
			switch(ch)
			{
				case 1:st.insertbegin(ele);break;	
				case 2:st.insertend(ele);break;
				case 3:do
					   {
							System.out.println("Enter pos (1 to " + (st.count+1) + ")" );
							pos=ob.nextInt();					  
					   }while(pos<1  ||  pos>st.count+1);
					   st.insertpos(pos, ele);
					   break;
				case 4:st.deletebeg();break;			
				case 5: st.deleteend();break;
				case 6:do
					   {
							System.out.println("Enter pos (1 to " + st.count + ")" );
							pos=ob.nextInt();					  
					   }while(pos<1  ||  pos>st.count);
					   st.deletepos(pos);
					   break;
				case 7:st.display();break;
				case 8: break;
				default:System.out.println("Invalid choice");
			}
		}while(ch!=8);
	}

}
