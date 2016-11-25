package com.wrox.algorithms.iteration;

public class ArrayIterator<T> implements Iterator<T> {
	
	private final T[] array;
	private final int start;
	private final int end;
	private int current = -1;

	public ArrayIterator(T[] array, int start, int lenght) {
		
		assert array != null;
		assert start >= 0;
		assert start < array.length;
		assert lenght >= 0;
		this.array = array;
		this.start = start;
		this.end = start + lenght - 1;
		assert end < array.length;
	}

	public ArrayIterator(T[] array) {
		assert array != null;
		this.array = array;
		this.start = 0;
		this.end = array.length -1;
	}

	@Override
	public void first() {
		this.current = this.start;
		
	}

	@Override
	public void last() {
		this.current = this.end;
		
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.current < this.start || this.current > this.end;
	}

	@Override
	public void next() {
		this.current ++;
		
	}

	@Override
	public void previous() {
		this.current --;
		
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		if(isDone()){
			throw new IteratorOutOfBoundsException();
		}
		return this.array[current];
	}

}
