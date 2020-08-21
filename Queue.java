package edu.amrita.cb.cen.mtech2019.sads;

public interface Queue {

	public void enqueue(int e) throws Exception;
	public int dequeue() throws Exception;
	public boolean isEmpty();
	public void print();
}
