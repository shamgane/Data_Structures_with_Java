package edu.amrita.cb.cen.mtech2019.sads;

public class StackArray2 implements Stack{
	Array stack;
	int top;
	
	public StackArray2() {
		stack = new Array();
		top = -1;
	}

	@Override
	public void push(int e) throws Exception {
		stack.append(e) ;
		top++;
	}

	@Override
	public int pop() throws Exception {
		
		if(isEmpty()) 
			throw new Exception("Underflow!");
		
		else  { 
			int v = stack.valueAt(top);
			top --;
			return v;
		}
	
	}

	@Override
	public void print() {
		
		for(int i = top; i>=0 ;i--)
			System.out.println(stack.valueAt(i));
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public static void main(String[] args) throws Exception{
		Stack s = new StackArray2();
		
		s.push(3);
		s.push(5);
		s.push(10);
		s.push(4);
		s.push(2);
		s.push(9);
		
		s.print();
	}
}
