package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.sets.Set;

public class MapSet<T> implements Set<T>{
	
	private final Map<T, ?> entries;
	
	

	public MapSet(Map<T, ?> entries) {		
		this.entries = entries;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new KeyIterator(entries.iterator());
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		if(contains(value)){
			return false;
		}
		this.entries.set(value, null);
		return true;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		if(!this.entries.contains(value)){
			return false;
		}
		this.entries.delete(value);
		return true;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return this.entries.contains(value);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.entries.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.entries.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.entries.isEmpty();
	}

}
