package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class QuicksortListSorter<T> implements ListSorter<T> {
	
	private final Comparator<T> comparator;

	public QuicksortListSorter(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator cannot be null";
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> list) {
		// TODO Auto-generated method stub
		assert list != null : "list cannot be null";
		quicksort(list, 0, list.size() - 1);
		return list;		
	}

	private void quicksort(List<T> list, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		if(startIndex < 0 || endIndex >= list.size()){
			return;
		}
		if(startIndex >= endIndex){
			return;
		}
		
		T value = list.get(endIndex);
		int partition = partition(list, value, startIndex, endIndex - 1);
		if(this.comparator.compare(list.get(partition), value) < 0){
			partition ++;
		}
		swap(list, partition, endIndex);
		
		quicksort(list, startIndex, partition - 1);
		quicksort(list, partition + 1, endIndex);
		
	}

	private int partition(List<T> list, T value, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		int left = leftIndex;
		int right = rightIndex;
		
		while(left < right){
			if(this.comparator.compare(list.get(left), value) < 0){
				left ++;
				continue;
			}
			if(this.comparator.compare(list.get(right), value) >= 0){
				right --;
				continue;
			}
			swap(list, left, right);
			left ++;
		}
		return left;
	}

	private void swap(List<T> list, int left, int right) {
		// TODO Auto-generated method stub
		if(left == right){
			return;
		}
		T tmp = list.get(left);
		list.set(left, list.get(right));
		list.set(right, tmp);
		
	}

}
