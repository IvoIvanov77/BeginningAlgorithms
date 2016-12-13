package com.wrox.algorithms.bsearch;

import java.util.Comparator;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.List;

public class LinearListSearcher<T> implements ListSearcher<T> {
	
	private final Comparator<T> comparator;

	public LinearListSearcher(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator can’t be null";
		this.comparator = comparator;	
	}

	@Override
	public int search(List<T> list, T value) {
		// TODO Auto-generated method stub
		assert list != null : "list can’t be null";
		
		int index = 0;
		Iterator<T> i = list.iterator();
		for(i.first(); !i.isDone(); i.next()){
			int cmp = this.comparator.compare(value, i.current());
			if(cmp == 0){
				return index;
			}else if(cmp < 0){
				break;
			}
			index ++;
		}
		return -(index + 1);
	}

}
