package com.wrox.algorithms.bsearch;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class RecursiveBinaryListSearcher<T> implements ListSearcher<T> {
	
	private final Comparator<T> comparator;

	public RecursiveBinaryListSearcher(Comparator<T> comparator) {
		assert comparator != null : "comparator can’t be null";
		this.comparator = comparator;
	}
	
	private int searchRecursively(List<T> list, T key, int lowerIndex, int upperIndex) {
			assert list != null : "list can’t be null";
			if(lowerIndex > upperIndex){
				return - (lowerIndex + 1);
			}
			
			int index = lowerIndex + (upperIndex - lowerIndex) / 2;
			int cmp = this.comparator.compare(key, list.get(index));
			if(cmp < 0){
				index = searchRecursively(list, key, lowerIndex, index - 1);
			}else if(cmp > 0){
				index = searchRecursively(list, key, index + 1, upperIndex);
			}
			
			return index;	
			
	}

	@Override
	public int search(List<T> list, T value) {
		// TODO Auto-generated method stub
		assert list != null : "list can’t be null";
		return searchRecursively(list, value, 0, list.size() - 1);
	}

}
