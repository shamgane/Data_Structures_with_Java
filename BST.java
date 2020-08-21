package edu.amrita.cb.cen.mtech2019.sads;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BST  implements Tree{

	class TNode {
		int data;
		TNode left;
		TNode right;
		
		public TNode(int d, TNode l, TNode r) {
			data = d;
			left = l;
			right = r;
		}
		
		public TNode(int d) {
			data = d;
			left = right = null;
		}
	}

	TNode root = null;
	
	
	public boolean isEmpty() {
		return (root == null);
	}
	
	@Override
	public void insert(int e) {
		root = insert_rec(e, root);
	}
	
	private TNode insert_rec(int e, TNode localRoot) {
		if( localRoot == null ) return new TNode(e);
		else {
			if(localRoot.data >= e) 
				localRoot.left = insert_rec(e, localRoot.left);
			else 
				localRoot.right = insert_rec(e, localRoot.right);
		
			return localRoot;
		}
		
	}
	
	
	

	@Override
	public void delete() {
		
		
	}

	@Override
	public void print() {
		System.out.println("Pre Order:");
		preorder(root);
		System.out.println("\nPost Order:");
		postorder(root);
		System.out.println("\nDFS:");
		dfs();
		System.out.println("\nBFS:");
		bfs();
	}
	
	public void inorder(TNode localRoot) {
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
	
	public void preorder(TNode localRoot) {
		if(localRoot == null) return;
		
		System.out.print(localRoot.data+ " ");
		preorder(localRoot.left);
		preorder(localRoot.right);

	}
	
	public void postorder(TNode localRoot) {
		if(localRoot == null) 
			return;
		
		postorder(localRoot.left);
		postorder(localRoot.right);
		System.out.print(localRoot.data+ " ");
	}
	
	public void bfs () {
		java.util.Queue<TNode> q = new LinkedList<TNode>();
		
		q.add(root);
		
		TNode local = null;
		
		while (!q.isEmpty()) {
			
			local = q.poll();
			
			if(local.left != null) q.add(local.left);
			if(local.right != null) q.add(local.right);
			
			System.out.print(local.data+ " ");
		}
	}
	
	public void dfs () {
		
		Deque<TNode> q= new ArrayDeque<TNode>();
		q.push(root);
		
		TNode local = null;
		
		while (!q.isEmpty()) {
			
			local = q.pop();
			
			if(local.left != null) q.push(local.left);
			if(local.right != null) q.push(local.right);
			
			System.out.print(local.data+ " ");
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Tree t = new BST();
		
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
