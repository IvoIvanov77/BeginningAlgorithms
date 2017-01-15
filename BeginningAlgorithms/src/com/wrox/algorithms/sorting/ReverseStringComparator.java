package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class ReverseStringComparator implements Comparator<String>{
	
	public final static  ReverseStringComparator INSTANCE = new ReverseStringComparator();
		
	private ReverseStringComparator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		assert s1 != null : "left can’t be null";
		assert s2 != null : "right can’t be null";
		return reverse(s1).compareTo(reverse(s2));
	}
	
	private String reverse(String s){
		StringBuilder result = new StringBuilder();
		for (int i = s.length() - 1; i >= 0;  i--) {
			result.append(s.charAt(i));
		}
		return result.toString();
	}

}
