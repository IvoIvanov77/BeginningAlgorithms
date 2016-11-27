package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertionSortListSorter.
 *
 * @param <T> the generic type
 */
public class InsertionSortListSorter<T> implements ListSorter<T> {
	
	/** The comparator. */
	private final Comparator<T> comparator;

	/**
	 * Instantiates a new insertion sort list sorter.
	 *
	 * @param comparator the comparator
	 */
	public InsertionSortListSorter(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "Comparator can't be null";
		this.comparator = comparator;
	}

	/** 
	 * my implementation
	 */
	@Override
	public List<T> sort(List<T> list) {
		// TODO Auto-generated method stub
		assert list != null : "list cannot be null";		
		
		for(int i = 1; i < list.size(); i ++){
			int index = i;
			T item = list.get(i);
			while(index > 0 && this.comparator.compare(item, list.get(index - 1)) < 0){
				index --;
			}
			list.insert(index, list.delete(i));
		}
		return list;
	}	
	
	public List<T> sortBookImplementation(List<T> list) {
		// TODO Auto-generated method stub
		assert list != null : "list cannot be null";		
		List<T> result = new LinkedList<>();
		
		Iterator<T> it = list.iterator();
		
		for(it.first(); !it.isDone(); it.next()){
			int slot = result.size();			
			while(slot > 0 ){
				if(comparator.compare(it.current(), result.get(slot - 1)) >= 0){
					break;
				}
				slot --;
			}
			result.insert(slot, it.current());
		}
		return result;
	}	

}
