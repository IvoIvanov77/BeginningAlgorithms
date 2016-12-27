package com.wrox.algorithms.sets;

import com.wrox.algorithms.bstrees.Node;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

public final class ValueIterator<T extends Comparable<T>> implements Iterator<T> {
	
	private Node<T> current;
	private Node<T> root;
	
	

	public ValueIterator(Node<T> root) {		
		this.root = root;
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		this.current = root != null ? root.minimum() : null;
		
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		this.current = root != null ? root.maximum() : null;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.current == null;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		if(!isDone()){
			current = current.successor();
		}
		
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		if(!isDone()){
			current = current.predecessor();
		}
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		// TODO Auto-generated method stub
		if(this.current == null){
			throw new IteratorOutOfBoundsException();
		}
		return this.current.getValue();
	}

}
