package edu.amrita.cb.cen.mtech2019.sads;

public interface Seq {
	
	public void append(int e);
	public void insertAt(int index, int e);
	public void replaceAt(int index, int e);
	public int valueAt(int i) throws IndexOutOfBoundsException;
	public int length();
}
