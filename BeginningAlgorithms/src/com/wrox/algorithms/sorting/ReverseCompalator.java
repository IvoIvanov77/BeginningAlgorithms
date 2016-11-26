package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class ReverseCompalator<T> implements Comparator<T> {
	
	private final Comparator<T> comparator;

	public ReverseCompalator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return this.comparator.compare(o2, o1);
	}
	
	

}
