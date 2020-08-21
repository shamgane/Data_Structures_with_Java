package edu.amrita.cb.cen.mtech2019.sads;

public class HeapTree implements Heap {

	int[] heap;
	int heapSize;
	
	public static final boolean MAX = true;
	public static final boolean MIN = false;		
	
	private boolean maxmin;
	
	public HeapTree(int capasity, boolean heapMode){
		heap = new int[capasity];
		heapSize = -1;
		maxmin = heapMode;
	}
	
	public HeapTree(int capacity) {
		this(capacity,MIN);
	}
	
	public HeapTree(int[] h, boolean decending) {
		heap = h;
		heapSize = -1;
		maxmin = decending;
	}
	
	public boolean isEmpty() {
		return (heapSize < 0);
	}
	
	public void insert(int e) {
		heap[++heapSize] = e;
		
		int i = heapSize;
		
		while( i != 0 && comp(heap[parent(i)], heap[i]) ) {
			swap(i,parent(i));
			i = parent(i);
		}
	}

	
	public int getTop() {
		return heap[0];
	}

	
	public int extTop() {
		int val = heap[0];
		swap(0,heapSize--);
		
		heapify(0);
		return val; 
		
	}

	public void decKey(int i, int newe) {
		if (comp(newe,heap[i])) { 
			return;
		}
		
		heap[i] = newe;
		
		while( i != 0 && comp(heap[parent(i)], heap[i]) ) {
			swap(i,parent(i));
			i = parent(i);
		}
	}

	
	public int left(int i) {
		return 2*i+1;
	}
	
	public int right(int i) {
		return 2*i+2;
	}

	
	public int parent(int i) {
		return (i-1)/2;
	}
	
	private void swap(int i, int j) {
		int t = heap[i];	
		heap[i] = heap[j];
		heap[j] = t;
	}

	public void heapify(int i) {
		int l = left(i);
		int r = right(i);
		
		int small = i;
		
		if(l <= heapSize && comp(heap[small], heap[l]) ) 
			small = l;
		if(r <= heapSize && comp(heap[small], heap[r]) )
			small = r;
		
		if(small != i){
			swap(i,small);
			heapify(small);
		}
	}
	
	public void print() {
		System.out.println();
		
		for(int i = 0; i<= heapSize; i++)
			System.out.print(heap[i]+ " ");
	}
	
	public boolean comp(int x, int y) {
		
		if(maxmin) return (x < y);
		else return (x > y);
		
	}

	public static void main(String[] args) {
		Heap h = new HeapTree(20, HeapTree.MIN);
		
		h.insert(50);h.print();
		h.insert(20);h.print();
		h.insert(25);h.print();
		h.insert(9);h.print();
		h.insert(8);h.print();
		h.insert(7);h.print();
		h.insert(5);h.print();
		h.insert(11);h.print();
		
		h.decKey(5,4);
		h.print();
		
		System.out.println(h.extTop());
		h.print();
	}
	
	
}
