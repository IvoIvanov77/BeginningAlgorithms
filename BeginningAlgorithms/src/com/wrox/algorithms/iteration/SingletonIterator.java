package com.wrox.algorithms.iteration;

public class SingletonIterator<T> implements Iterator<T>{
	
	private final T value;
	private boolean isDone;
	
	public SingletonIterator(T value) {
		assert !value.equals(null);
		this.value = value;
	}

	@Override
	public void first() {
		this.isDone = false;
		
	}

	@Override
	public void last() {
		this.isDone = false;
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.isDone;
	}

	@Override
	public void next() {
		this.isDone = true;
	}

	@Override
	public void previous() {
		this.isDone = true;
		
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		if(isDone()){
			throw new IteratorOutOfBoundsException();
		}
		return this.value;
	}

}
