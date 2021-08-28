package day9;

import day9.Node;
import day9.SLL;

public class ReverseList {

	static void reverseme(Node n)
	{
		if(n==null)
			return;
		reverseme(n.next);
		System.out.println(n.data);
	}
	
	public static void main(String[] args) {
		SLL ob = new SLL();
		
		ob.insertend(22);
		ob.insertend(33);
		ob.insertend(44);
		ob.insertend(55);
		ob.insertend(66);
		ob.display();
		System.out.println("reveresed = ");
		reverseme(ob.head);
	}

}
