package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class FixedComparator<T> implements Comparator<T>{
	
	private final int result;
	
	public FixedComparator(int result) {
		this.result = result;
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return result;
	}

}
