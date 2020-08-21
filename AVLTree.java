package edu.amrita.cb.cen.mtech2019.sads;

import edu.amrita.cb.cen.mtech2019.sads.BST.TNode;

/**
 * 
T1, T2, T3 and T4 are subtrees.
````````````````````````````````
a) Left Left Case
`````````````````
         z                                      y 
        / \                                   /   \
       y   T4      Right Rotate (z)          x      z
      / \          - - - - - - - - ->      /  \    /  \ 
     x   T3                               T1  T2  T3  T4
    / \
  T1   T2
  
b) Left Right Case
``````````````````
     z                              z                             x
    / \                            / \                          /   \ 
   y   T4  Left Rotate (y)        x   T4  Right Rotate(z)     y       z
  / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \     / \
T1   x                          y    T3                    T1  T2  T3   T4
    / \                        / \
  T2   T3                    T1   T2

c) Right Right Case
```````````````````
  z                                 y
 / \                              /   \ 
T1  y     Left Rotate(z)        z       x
   / \   - - - - - - - ->      / \     / \
  T2  x                       T1  T2  T3  T4
     / \
    T3  T4
     
d) Right Left Case
``````````````````
   z                            z                             x
  / \                          / \                          /   \ 
T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z       y
    / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \     / \
   x   T4                      T2   y                  T1  T2   T3  T4
  / \                              /  \
T2   T3                           T3   T4
 
*/


public interface AVLTree extends Tree{
	
	
	// Class for an AVl balancing node ...
	class AVLNode {
		
		int data;
		AVLNode left;
		AVLNode right;
		
		int height;
		
		public AVLNode(int d, AVLNode l, AVLNode r) {
			data = d;
			left = l;
			right = r;
			height = 0;
		}
		
		public AVLNode(int d) {
			this(d,null,null);
		}
	}
	
	public int getBalance(AVLNode n);
	public AVLNode rightRotate(AVLNode n);
	public AVLNode leftRotate(AVLNode n);
 	
}
