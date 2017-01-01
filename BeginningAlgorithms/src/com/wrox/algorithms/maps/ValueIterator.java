package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

public class ValueIterator<V> implements Iterator<V> {
	
	private final Iterator<Map.Entry<?, V>> iterator;
	
	public ValueIterator(Iterator<Map.Entry<?, V>> iterator) {
		// TODO Auto-generated constructor stub
		this.iterator = iterator;
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		this.iterator.first();
		
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		this.iterator.last();
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.iterator.isDone();
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		this.iterator.next();
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		this.iterator.previous();
	}

	@Override
	public V current() throws IteratorOutOfBoundsException {
		// TODO Auto-generated method stub
		
		return this.iterator.current().getValue();
	}

}
