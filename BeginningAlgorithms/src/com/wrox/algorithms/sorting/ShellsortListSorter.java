package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class ShellsortListSorter<T> implements ListSorter<T> {
	
	private final Comparator<T> comparator;
	private final int[] increments = {121, 40, 13, 4, 1};	

	public ShellsortListSorter(Comparator<T> comparator) {
		assert comparator != null : "comparator cannot be null";
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> list) {
		// TODO Auto-generated method stub
		assert list != null : "list cannot be null";
		for (int i = 0; i < increments.length; i++) {
			int increment = increments[i];
			hSort(list, increment);
		}
		return list;
	}

	private void hSort(List<T> list, int increment) {
		// TODO Auto-generated method stub
		if(list.size() < increment * 2){
			return;
		}
		for (int i = 0; i < increment; i++) {
			sortSublist(list, i, increment);
		}
	}

	private void sortSublist(List<T> list, int startIndex, int increment) {
		// TODO Auto-generated method stub
		for (int i = startIndex + increment; i < list.size(); i += increment ) {
			T value = list.get(i);
			int j;
			for (j = i; j > startIndex; j -= increment) {
				T previousValue = list.get(j - increment);
				if(comparator.compare(value, previousValue) >= 0){
					break;
				}
				list.set(j, previousValue);
			}
			list.set(j, value);
		}
		
	}

}
