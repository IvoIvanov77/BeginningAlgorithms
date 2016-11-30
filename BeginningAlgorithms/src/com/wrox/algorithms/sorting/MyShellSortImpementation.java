package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class MyShellSortImpementation<T> implements ListSorter<T> {

	private final Comparator<T> comparator;
	private final int[] increments = { 121, 40, 13, 4, 1 };

	public MyShellSortImpementation(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> list) {
		for(int i = 0; i < increments.length; i ++){
			hSort(list, increments[i]);
		}
		return list;
	}

	private void hSort(List<T> list, int increment) {
		if(list.size() < increment * 2){
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			sortSublist(list, i, increment);
		}
	}

	private void sortSublist(List<T> list, int startIndex, int increment) {
		// TODO Auto-generated method stub
		for(int i = startIndex + increment; i < list.size(); i += increment){
			T value = list.get(i);
			int j;
			for(j = i; j > startIndex; j -= increment){
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
