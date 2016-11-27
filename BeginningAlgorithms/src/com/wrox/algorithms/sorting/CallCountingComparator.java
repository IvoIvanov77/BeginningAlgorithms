package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class CallCountingComparator<T> implements Comparator<T> {
	
	private final Comparator<T> comparator;
	private int callCount;

	public CallCountingComparator(Comparator<T> comparator) {
		assert comparator != null : "comparator cannot be null";
		this.comparator = comparator;
		this.callCount = 0;
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		callCount ++;
		return this.comparator.compare(o1, o2);
	}

	public int getCallCount() {
		return callCount;
	}	

}
