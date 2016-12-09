package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

public class MergesortListSorter<T> implements ListSorter<T> {
	
	private final Comparator<T> comparator;
	
	public MergesortListSorter(Comparator<T> comparator) {
		assert comparator != null : "comparator cannot be null";
		this.comparator = comparator;
	}

	@Override
	public List<T> sort(List<T> list) {
		// TODO Auto-generated method stub
		assert list != null : "list cannot be null";
		return mergesort(list, 0, list.size() - 1);
	}

	private List<T> mergesort(List<T> list, int start, int end) {
		// TODO Auto-generated method stub
		if(start == end){
			List<T> result = new ArrayList<>();
			result.add(list.get(start));
			return result;
		}
		int middle = start + (end - start) / 2;
		List<T> left = mergesort(list, start, middle);
		List<T> right = mergesort(list, middle + 1, end);
		return merge(left, right);
	}

	private List<T> merge(List<T> left, List<T> right) {
		// TODO Auto-generated method stub
		List<T> result = new ArrayList<>();
		
		Iterator<T> l = left.iterator(); 
		Iterator<T> r = right.iterator();
		
		l.first();
		r.first();
		
		while(!(l.isDone() && r.isDone())){
			if(l.isDone()){
				result.add(r.current());
				r.next();
			} else if(r.isDone()){
				result.add(l.current());
				l.next();
			} else if(this.comparator.compare(l.current(), r.current()) < 0){
				result.add(l.current());
				l.next();
			}else {
				result.add(r.current());
				r.next();
			}
		}
		return result;
	}

}
