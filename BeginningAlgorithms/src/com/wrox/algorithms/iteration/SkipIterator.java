package com.wrox.algorithms.iteration;

public class SkipIterator<T> implements Iterator<T>{
	
	private final Iterator<T> iterator;
	private final int skip;
	
	public SkipIterator(Iterator<T> iterator, int skip) {

		assert iterator != null : "iterator can’t be null";
		assert skip > 0 : "skip can’t be < 1";
		this.iterator = iterator;
		this.skip = skip;
	}

	@Override
	public void first() {
		iterator.first();
		skipForwards();
		
	}

	@Override
	public void last() {
		iterator.last();
		skipBackwards();
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.iterator.isDone();
	}

	@Override
	public void next() {
		this.iterator.next();
		skipForwards();
		
	}

	@Override
	public void previous() {
		this.iterator.previous();
		skipBackwards();
		
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		
		return this.iterator.current();
	}
	
	private void skipForwards(){
		for(int i = 1; i < this.skip && !iterator.isDone(); i ++){
			iterator.next();
		}
	}
	
	private void skipBackwards(){
		for(int i = 1; i < this.skip && !iterator.isDone(); i ++){
			iterator.previous();
		}
	}

}
