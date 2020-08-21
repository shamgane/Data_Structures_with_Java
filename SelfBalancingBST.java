package edu.amrita.cb.cen.mtech2019.sads;

public class SelfBalancingBST implements AVLTree, Tree{

	AVLNode root = null;
	
	@Override
	public void insert(int e) {
		root = insert_rec(root, e);
	}
	
	private int max(int a,int b) {
		if(a>b) return a;
		else return b;
	}
	
	// Necessary to check null before calling height ...
	private int height(AVLNode n) {
		if(n == null) return 0;
		
		return n.height;
	}
	
	private AVLNode insert_rec(AVLNode root, int e) {
		if(root == null) root = new AVLNode(e);
		
		else if(root.data > e) root.left = insert_rec(root.left, e);
		else root.right = insert_rec(root.right, e);
		
		root.height = max(height(root.left), height(root.right)) + 1;
		int balance = getBalance(root);
		
		// LL case
		if(balance > 1 && e < root.left.data) 
			return rightRotate(root);
		// LR case
		if(balance > 1 && e >= root.left.data) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		// RR case
		if(balance < -1 && e >= root.right.data) 
			return leftRotate(root);
		// RL case
		if(balance < -1 && e < root.right.data) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		
		return root;
		
	}

	@Override
	public void delete() {
	
		
	}

	@Override
	public boolean isEmpty() {
		
		return false;
	}

	
	public void print() {
		System.out.println("In Order:");
		inorder(root);
		//System.out.println("\nPost Order:");
		//postorder(root);
		//System.out.println("\nDFS:");
	}
	
	public void inorder(AVLNode localRoot) {
		if(localRoot == null) {
			System.out.print(" . ");
			return;
		}
		System.out.print("{");
		inorder(localRoot.left);
		System.out.print(localRoot.data);
		inorder(localRoot.right);
		System.out.print("}");
	}
	
	public void preorder(AVLNode localRoot) {
		if(localRoot == null) return;
		
		System.out.print(localRoot.data+ " ");
		preorder(localRoot.left);
		preorder(localRoot.right);

	}
	
	public void postorder(AVLNode localRoot) {
		if(localRoot == null) 
			return;
		
		postorder(localRoot.left);
		postorder(localRoot.right);
		System.out.print(localRoot.data+ " ");
	}
	
	
	
	public int getBalance(AVLNode n){
		
		if(n == null) return 0;
		
		return ( height(n.left) - height(n.right) );
	}

	
	public AVLNode rightRotate(AVLNode n) {
		if(n == null) return n;
		
		AVLNode y = n.left;
		n.left = y.right;
		y.right = n;
		
		n.height = max (height(n.left), height(n.right) ) + 1;
		y.height = max (height(y.left), height(y.right) ) + 1;
		
		return y;
	}

	
	public AVLNode leftRotate(AVLNode n) {
		if(n == null) return n;
		
		AVLNode y = n.right;
		n.right = y.left;
		y.left = n;
		
		n.height = max (height(n.left), height(n.right) ) + 1;
		y.height = max (height(y.left), height(y.right) ) + 1;
		
		return y;
	}
	
public static void main(String[] args) throws Exception {
		
		Tree t = new SelfBalancingBST();
		
		t.insert(20);
		t.insert(19);
		t.insert(18);
		
		t.print();
		
		t.insert(17);
		t.insert(16);
		t.insert(15);
		t.insert(14);
		
		t.print();
		
		t.insert(13);
		t.insert(25);
		
		t.print();
		
	}

}
