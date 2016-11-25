package com.wrox.algorithms.iteration;

public class EmptyIterator<T> implements Iterator<T>{
	
	@SuppressWarnings("rawtypes")
	public static  final EmptyIterator INSTANCE = new EmptyIterator<>();
	
	private EmptyIterator() {
		// TODO Auto-generated constructor stub
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
		return true;
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
		throw new IteratorOutOfBoundsException();
	}

}
