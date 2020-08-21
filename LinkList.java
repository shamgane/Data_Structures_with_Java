package edu.amrita.cb.cen.mtech2019.sads;

public class LinkList implements Seq{

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
	
	Node start,last;
	int size = 0;
	
	public int length() {
		return size;
	}
	
	public boolean isEmpty() {
		return (start == null);
	}
	
	@Deprecated
	public void appendC(int e) {
		if (isEmpty()) start = new Node(e);
		else {
			Node ptr;
			for(ptr = start; ptr.next !=null; ptr = ptr.next);
			ptr.next = new Node(e);
		}
	}
	
	public int valueAt(int i) throws IndexOutOfBoundsException{
		int j = 0;
		Node ptr = null;
		for(ptr = start; 
				ptr != null && j!=i; 
				ptr = ptr.next, j++);
		
		if (ptr == null) 
			throw new IndexOutOfBoundsException(
					"List Index Out of bounds: "+i 
					);
		
		return ptr.data;
	}
	
	public void append(int e) {
		if (isEmpty()) {
			start = new Node(e);
			last = start;
		}
		else {
			last.next = new Node(e);
			last = last.next;
		}
		size++;
	}
	
	public String toString() {
		if (isEmpty()) return "Empty";
		else {
			String list = "List(";
			
			for(Node ptr = start; ptr != last; ptr = ptr.next)
				list += ptr.data+",";
			
			list += last.data + ")";
			
			return list;
		}	
	}
	
	
	public LinkList concat(LinkList that) {
		LinkList combined = new LinkList();
		
		for(Node ptr = this.start; ptr != null; ptr = ptr.next)
			combined.append(ptr.data);
		
		for(Node ptr = that.start; ptr != null; ptr = ptr.next)
			combined.append(ptr.data);
		
		return combined;
	}
	
	
	public void insertAt(int index, int e) {
		if(isEmpty()) {
			start = new Node(e);
			last = start;
		}
		else {
			
			int c;
			Node ptr;
			
			if(index == 0) {
				ptr = new Node(e,start);
				start = ptr;
				return;
			}
		
			for(ptr = start, c = 0; 
					(c < index-1) && (ptr != null); 
					c++, ptr = ptr.next ); 
			
			if(ptr == null) {
				last.next = new Node(e);
				last = last.next;
			}
			else {
				ptr.next = new Node(e, ptr.next);
				if (ptr.next.next == null) last = ptr.next;
			}	
		}
		size++;
		
	}
	
	public static void main(String[] args) {
		LinkList aInt = new LinkList();
		LinkList bInt = new LinkList();
		
		System.out.println(aInt);
		
		//System.out.println(aInt.hashCode());
		//System.out.println(bInt.hashCode());
		
		aInt.append(5);
		aInt.append(9);
		
		System.out.println(aInt);
		System.out.println(bInt);
		aInt.append(6);
		aInt.append(7);
		aInt.append(8);
		aInt.append(2);
		
		aInt.insertAt(7,12);
		
		System.out.println(aInt);
		System.out.println(bInt);
	}

	@Override
	public void replaceAt(int index, int e) {
		// TODO Auto-generated method stub
		
	}
	
}


