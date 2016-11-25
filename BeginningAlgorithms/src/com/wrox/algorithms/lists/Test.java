package com.wrox.algorithms.lists;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> a = new ArrayList<>();
		a.add("A");
		a.add("B");
		a.insert(0, "C");
		LinkedList<String> b = new LinkedList<>();
		b.add("A");
		b.add("B");
		System.out.println(a.isEqual(b));
		System.out.println(a);
		System.out.println(b);
		System.out.println(b.getHead());
		System.out.println(b.getTail());

	}

}
