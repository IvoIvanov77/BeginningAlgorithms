package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class NaturalComparator<T extends Comparable<T>> implements Comparator<T> {	
	

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}

}
