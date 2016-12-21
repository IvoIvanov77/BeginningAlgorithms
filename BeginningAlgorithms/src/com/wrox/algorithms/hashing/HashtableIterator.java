package com.wrox.algorithms.hashing;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

public class HashtableIterator<T> implements Iterator<T>{
	
	private final Iterator<T> buckets;
    private Iterator<T> values = EmptyIterator.INSTANCE;
    
    

	public HashtableIterator(Iterator<T> buckets) {
		assert buckets != null : "buckets can't be null";
		this.buckets = buckets;
		
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

}
