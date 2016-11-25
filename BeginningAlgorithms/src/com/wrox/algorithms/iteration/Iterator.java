package com.wrox.algorithms.iteration;

public interface Iterator<T> {
	
	public void first();
	public void last();
	public boolean isDone();
	public void next();
	public void previous();
	public T current() throws IteratorOutOfBoundsException;

}
