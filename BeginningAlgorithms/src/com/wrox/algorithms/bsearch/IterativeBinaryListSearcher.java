package com.wrox.algorithms.bsearch;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class IterativeBinaryListSearcher<T> implements ListSearcher<T> {
	
	private final Comparator<T> comparator;

	public IterativeBinaryListSearcher(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator can’t be null";
		this.comparator = comparator;
		
	}

	@Override
	public int search(List<T> list, T value) {
		// TODO Auto-generated method stub
		assert list != null : "list can’t be null";
		int lowerIndex = 0;
		int upperIndex = list.size() - 1;
		while(lowerIndex <= upperIndex) {
			int index = lowerIndex + (upperIndex - lowerIndex) / 2;
			int cmp = this.comparator.compare(value, list.get(index));
			if(cmp == 0){
				return index;
			}else if(cmp > 0){
				lowerIndex = index + 1;
			}else {
				upperIndex = index - 1;
			}
		}
		return -(lowerIndex + 1);
	}

}
