package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

public class GenericListIterator<T> implements Iterator<T> {
	
	private final List<T> list;
	private int current;
	
	public GenericListIterator(List<T> list) {
		assert list != null : "list can’t be null";
		this.list = list;
	}

	@Override
	public void first() {
		this.current = 0;
		
	}

	@Override
	public void last() {
		this.current = list.size() - 1;
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return current < 0 || current > list.size() - 1;
	}

	@Override
	public void next() {
		current ++;
		
	}

	@Override
	public void previous() {
		current --;
		
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		if(isDone()){
			throw new IteratorOutOfBoundsException();
		}
		return list.get(current);
	}

}
