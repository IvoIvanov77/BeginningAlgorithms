package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterator;

@SuppressWarnings("rawtypes")
public final class EmptySet implements Set{
	
	public final static EmptySet INSTANCE = new EmptySet();	

	private EmptySet() {
		
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new EmptyIterator<>();
	}

	@Override
	public boolean add(Object value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(Object value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

}
