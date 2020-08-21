//package edu.amrita.cb.cen.mtech2019.sads;

public class QueueArray implements Queue{
	int[] queue;
	int front, rear;
	
	public QueueArray(int size) {
		queue = new int[size];
		front = rear = -1;
	}
	
	public boolean isEmpty() {
		return (front < 0);
	}

	@Override
	public void enqueue(int e) throws Exception {
		if (isEmpty()) {
			queue[++rear] = e;
			front++;
		}
		else {
			int nrear = (rear+1) % queue.length;
			
			if(nrear == front)
				throw new Exception("Overflow!");
			
			queue[rear = nrear] = e;
		}
	}

	@Override
	public int dequeue() throws Exception {
		if(isEmpty()) 
			throw new Exception("Underflow!");
		
		int v = queue[front];
		
		if(front == rear) front = rear = -1;
		else front = (front + 1) % queue.length;
		
		return v;
	}

	@Override
	public String toString() {
		
		if(isEmpty()) return "Empty";
		else {
			String arr = "Queue(";
			
			for( int i=front; i != rear; i = (i+1) % queue.length )
				arr += this.queue[i]+ ",";
			
			arr += this.queue[rear] + ")";
			return arr;
		}
		
	}

	@Override
	public void print() {
		System.out.println(this);
	}
	
	public static void main(String[] args) throws Exception {
		Queue q = new QueueArray(6);
		
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(2);
		q.enqueue(9);
		q.enqueue(7);
		q.enqueue(10);
		
		q.print();
		
		System.out.println("Deleting..."+q.dequeue());
		q.print();
		System.out.println("Deleting..."+q.dequeue());
		q.print();
		q.enqueue(21);
		q.print();
		System.out.println("Deleting..."+q.dequeue());
		q.print();
		System.out.println("Deleting..."+q.dequeue());
		q.print();
		q.enqueue(25);
		q.print();
		System.out.println("Deleting..."+q.dequeue());
		q.print();
		System.out.println("Deleting..."+q.dequeue());
		q.print();
		q.enqueue(20);
		q.print();
	}
}
