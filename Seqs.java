package edu.amrita.cb.cen.mtech2019.sads;

public class Seqs {
	
	public static void print(Seq s) {
		System.out.println(s);
		System.out.println(s.length());	
	}
	
	public static void main(String[] args ) {
		Seq aInt = new Array();
		Seq bInt = new LinkList();
		
		System.out.println(aInt.hashCode());
		System.out.println(bInt.hashCode());
		
		aInt.append(5);
		bInt.append(9);
				
		System.out.println(aInt);
		System.out.println(bInt);
		aInt.insertAt(10,6);
		bInt.append(7);
		aInt.replaceAt(8,8);
		bInt.append(10);
		
		System.out.println(aInt);
		System.out.println(bInt);
		
		try {
			System.out.println(aInt.valueAt(10));
			System.out.println(bInt.valueAt(2));
		}catch(Exception e) { System.err.println(e.getMessage()) ; }
		
		print(aInt);
		print(bInt);
		
	}

}
