package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.*;

public class ListSet<T> implements Set<T> {
	
	private final List<T> values = new LinkedList<>();

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.values.iterator();
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		if(this.values.contains(value)){
			return false;
		}
		this.values.add(value);
		return true;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		return this.values.delete(value);
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return this.values.contains(value);
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

	@Override
	public String toString() {
		return this.values.toString();
	}
	
	

}
