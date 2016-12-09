package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

public class CompoundComparator<T> implements Comparator<T> {
	
	private List<Comparator<T>> comparators = new ArrayList<>();

	public void addComparator(Comparator<T> comparator) {
		assert comparator != null : "comparator can’t be null";
		assert comparator != this : "can’t add comparator to itself";
		comparators.add(comparator);
		
	}

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		int result = 0;
		Iterator<Comparator<T>> iterator = comparators.iterator();
		for(iterator.first(); !iterator.isDone(); iterator.next()){
			result = iterator.current().compare(o1, o2);
			if(result != 0){
				break;
			}
		}		
		return result;
	}

}
