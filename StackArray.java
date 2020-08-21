package edu.amrita.cb.cen.mtech2019.sads;


public class StackArray implements Stack{
	
	int[] stack;
	int top;
	
	public StackArray(int size) {
		stack = new int[size];
		top = -1;
	}

	@Override
	public void push(int e) throws Exception {
		
		if (top == stack.length - 1) 
			throw new Exception("Overflow!");
		
		stack[++top] = e;
	}

	@Override
	public int pop() throws Exception {
		
		if(isEmpty()) 
			throw new Exception("Underflow!");
		
		return stack[top--];
	
	}

	@Override
	public void print() {
		
		for(int i = top; i>=0 ;i--)
			System.out.println(stack[i]);
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public static void main(String[] args) throws Exception{
		Stack s = new StackList();
		
		s.push(3);
		s.push(5);
		s.push(10);
		s.push(4);
		s.push(2);
		s.push(9);
		
		s.print();
	}
}
