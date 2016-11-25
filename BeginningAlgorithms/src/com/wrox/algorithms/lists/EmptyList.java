package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterator;

public class EmptyList<T> implements List<T> {

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return EmptyIterator.INSTANCE;
	}

	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void add(T value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();	
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		
	}

	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
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
