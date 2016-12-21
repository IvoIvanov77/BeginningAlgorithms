package com.wrox.algorithms.iteration;


public class ReverseIterator<T> implements Iterator<T>{
	
	private final Iterator<T> iterator;
	
	public ReverseIterator(Iterator<T> iterator){
		this.iterator = iterator;
	}

	@Override
	public void first() {
		this.iterator.last();
		
	}

	@Override
	public void last() {
		this.iterator.first();
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.iterator.isDone();
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		this.iterator.previous();
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		this.iterator.next();
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		// TODO Auto-generated method stub
		return this.iterator.current();
	}

}
