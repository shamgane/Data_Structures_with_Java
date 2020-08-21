package edu.amrita.cb.cen.mtech2019.sads;

public class StackList implements Stack, Queue {

	class Node {
		int data;
		Node next;
		
		public Node(int d, Node n) {
			data = d;
			next = n;
		}
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}

	Node top = null;
	
	
	@Override
	public void push(int e) throws Exception {
		top = new Node(e,top);	
	}

	@Override
	public int pop() throws Exception {
		if(isEmpty()) 
			throw new Exception("Underflow!");
		else {
			int v = top.data;
			top = top.next;
			return v;
		}
	}

	@Override
	public void print() {

		for(Node ptr = top; ptr != null; ptr = ptr.next)
				System.out.println(ptr.data);
		
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public void enqueue(int e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int dequeue() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
