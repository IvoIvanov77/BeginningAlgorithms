package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class SelectionSortListSorter<T> implements ListSorter<T> {
	
	private final Comparator<T> comparator;

	public SelectionSortListSorter(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "Comparator can't be null";
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> list) {
		// TODO Auto-generated method stub
		assert list != null : "list cannot be null";
		for(int i = 0; i < list.size() - 1; i ++){
			int min = i;
			for(int j = i + 1; j < list.size(); j ++){
				int current = j;
				if(this.comparator.compare(list.get(min), list.get(current)) > 0){
					min = current;
				}
			}
			swap(list, i, min);
		}
		return list;
	}
	
	private void swap(List<T> list, int left, int right){
		if(left == right){
			return;
		}
		T item = list.get(left);
		list.set(left, list.get(right));
		list.set(right, item);
	}

}
