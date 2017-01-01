package com.wrox.algorithms.sets;

import java.util.Comparator;
import com.wrox.algorithms.bsearch.*;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.*;
import com.wrox.algorithms.sorting.NaturalComparator;

public class SortedListSet<T extends Comparable<T>> implements Set<T> {
	
	private final List<T> values = new ArrayList<>();
	private final ListSearcher<T> searcher;
	
	public SortedListSet() {
		// TODO Auto-generated constructor stub
		this(new NaturalComparator<T>());
	}


	public SortedListSet(Comparator<T> comparator) {
		this.searcher = new IterativeBinaryListSearcher<>(comparator);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.values.iterator();
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		int index = indexOf(value);
		if(index < 0){
			this.values.insert(- (index + 1), value);
			return true;
		}
		this.values.set(index, value);
		return false;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		int index = indexOf(value);{
			if(index >= 0){
				this.values.delete(index);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return indexOf(value) >= 0;
	}

	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.values.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.values.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.values.isEmpty();
	}
	
	private int indexOf(T value) {
		// TODO Auto-generated method stub
		return this.searcher.search(this.values, value);
	}

}
