package edu.amrita.cb.cen.mtech2019.sads;

public class CompleteBTree implements Tree {

	private int[] btree;
	private int count;
	
	public CompleteBTree(int size) {
		btree = new int[size];
		count = -1;
	}
	
	
	public int left(int i) {
		return 2*i + 1;
	}
	
	public int right(int i) {
		return 2*i + 2;
	}
	
	public int data(int i) {
		return btree[i];
	}
	
	@Override
	public void insert(int e) {
		btree[++count] = e;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method	
	}

	@Override
	public boolean isEmpty() {
		return count==-1;
	}

	@Override
	public void print() {
		System.out.println();
		inorder(0);
	}
	
	public void inorder(int root) {
		if(root > count) return;
		
		inorder(left(root));
		System.out.print(data(root) +" ");
		inorder(right(root));	
		
	}
	
public static void main(String[] args) throws Exception {
		
		Tree t = new CompleteBTree(15);
		
		t.insert(5);
		t.insert(8);
		t.insert(3);
		
		//t.print();
		
		t.insert(2);
		t.insert(4);
		t.insert(7);
		t.insert(9);
		
		//t.print();
		
		t.insert(1);
		t.insert(6);
		
		t.print();
		
	}
	
	

}
