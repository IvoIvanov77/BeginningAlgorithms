package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class BubblesortListSorter<T> implements ListSorter<T> {
	
	private final Comparator<T> comparator;

	public BubblesortListSorter(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "Comparator can't be null";
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> list) {
		assert list != null : "list cannot be null";
		
		for(int i = 1; i < list.size(); i ++){
			boolean flag = false;
			for (int j = 0; j < list.size() - i; j++) {
				if(this.comparator.compare(list.get(j), list.get(j + 1)) > 0){
					swap(list, j);
					flag = true;
				}				
			}
			if(!flag){
				break;
			}
		}
		return list;
	}
	
	private void swap(List<T> list, int index){
		T current = list.get(index);		
		list.set(index, list.get(index + 1));
		list.set(index + 1, current);
	}

}
