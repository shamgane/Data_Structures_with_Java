package edu.amrita.cb.cen.mtech2019.sads;

public interface Heap {

	public void insert(int e);
	public int getTop();
	public int extTop();
	public void decKey(int i, int eLess);
	public int left(int i);
	public int right(int i);
	public int parent(int i);
	public boolean isEmpty();
	public void heapify(int i);
	public void print();
}
