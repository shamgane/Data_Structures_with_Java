package edu.amrita.cb.cen.mtech2019.sads;

import java.util.Random;

/**
 * This class represents a 'Feature Rich' Array in Java. The idea of making such a class is to
 * demonstrate the concept of abstraction and how it can add newer features to an existing array.
 * It also gives a standard implementation of the Abstract (not real) data type 'Sequence' called 
 * 'Seq'.  
 *   
 * @author vijaykrishnamenon 
 *
 */

public class Array implements Seq{
	
	// An internal Random Generator for Generation Arrays with Random values like in Matlab.
	static Random rand = new Random();
	
	// The Containing array used to hold the data in memory. 
	private int[] a;
	
	//Size is the number of location really used. It decouples length and the count of values. 
	//This allows the array to grow dynamically, even though it has some memory overhead.
	//Invariant: size being negative shows an empty array.
	private int size = -1;
	
	/**
	 *  Makes an Empty Array of said size ...
	 * @param size
	 */
	public Array (int size) {
		a = new int[size];
		rand.setSeed(size);
	}

	/**
	 *  Makes an empty array of default (1000) size ...
	 */
	public Array() {
		this(1000);
	}
	
	/**
	 *  Makes an empty array of said 'size' with random integers with in range 0 to 'range'...
	 *  @param size, range, seed
	 **/
	public Array(int size, int range, int seed ) {
		rand.setSeed(seed);
		a = new int[size];
		
		for(int i=0; i<size; i++)
			append(rand.nextInt(range));
	}
	
	/**
	 * Appends value 'e' to the end of the array.
	 */
	
	public void append(int e) {
		if( (size+1) == a.length) 
			System.err.println("Overflow! cannot insert anymore");
		else {
			a[size+1] = e;
			size++;
		}
	}
	
	/**
	 * returns used length of the array ...
	 */
	public int length() {
		return size+1;
	}
	
	/**
	 * Subscripts and access the value at a given index position. 
	 */
	public int valueAt(int i) 
			throws IndexOutOfBoundsException {
		try {
			return a[i];
		}catch(Exception e) {
			throw new IndexOutOfBoundsException(
					"List Index Out of bounds: "+i 
					);
		}
	}
	
	/**
	 * Rerwite the value at position 'i' with value 'e'
	 */
	public void replaceAt(int index,int e) {
		if (index > size) 
			System.err.println("Out of Bounds! MaxValue: "+ size);
		else  a[index] = e;
	}
	
	/**
	 * Inserts a value 'e' at position 'index'. The value already there will be moved to 'index + 1' 
	 * iteratively. 
	 */
	public void insertAt(int index, int e) {
		if( (size+1) == a.length || index >= a.length) 
			System.err.println("Overflow! cannot insert anymore");
		
		else if (index <= size){
			for(int j = size; j >= index; j--)
				a[j+1] = a[j];
			a[index] = e;
			size++;
		}
		
		else {
			a[index] = e;
			size = index;
		}
	}
	
	// Checks the emptiness invariant. 
	public boolean isEmpty() {
		return (size < 0);
	}
	
	// Concatenates two Arrays into a third array. The original Arrays are not changed. 
	public Array concat(Array that) {
		Array combined = new Array(this.size + that.size + 2);
		
		for(int i=0;i<=this.size;i++)
			combined.append(this.a[i]);
		
		for(int j=0;j<=that.size;j++)
			combined.append(that.a[j]);
		
		return combined;
	}
	
	/**
	 * Gives a String representation of the Array object, other than the default behavior 
	 * for normal Java arrays.	 
	 *  
	 * @see java.lang.Object#toString()
	 */
	
	public String toString() {
		if(isEmpty()) return "Empty";
		else {
			String arr = "Array(";
			
			for( int i=0; i < this.size; i++ )
				arr += this.a[i]+ ",";
			
			arr += this.a[this.size] + ")";
			return arr;
		}
	}

	/*
	 * A Test main. 
	 */
	public static void main(String[] args) {
		Array aInt = new Array();
		Array bInt = new Array();
		
		System.out.println(aInt.a[0]);
		
		System.out.println(aInt.hashCode());
		System.out.println(bInt.hashCode());
		aInt.append(5);
		bInt.append(9);
		System.out.println(aInt);
		System.out.println(bInt);
		aInt.insertAt(10,6);
		bInt.insertAt(9,7);
		aInt.replaceAt(8,8);
		bInt.replaceAt(7,9);
		
		System.out.println(aInt);
		System.out.println(bInt);
		
		try {
			System.out.println(aInt.valueAt(10));
			System.out.println(bInt.valueAt(10));
		}catch(Exception e) { System.err.println(e.getMessage()) ; }
		
		System.out.println(aInt.concat(bInt));
		
		String a = "Hello";
		String a_ = a.replace('l', '2');
		System.out.println(a_);
		System.out.println(a);
		
	}
		
}
