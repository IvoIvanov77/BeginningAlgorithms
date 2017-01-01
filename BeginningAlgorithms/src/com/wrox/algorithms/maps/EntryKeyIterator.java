package com.wrox.algorithms.maps;

import com.wrox.algorithms.bstrees.Node;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

public class EntryKeyIterator<T> implements Iterator<T>{
	
	private final Node<T> root; 
	private Node<T> current;
	
	

	public EntryKeyIterator(Node<T> node) {		
		this.root = node;
	}

	@Override
	public void first() {
		current = root != null ? root.minimum() : null;
		
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		current = root != null ? root.maximum() : null;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return current == null;
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
		if(current == null){
			throw new IteratorOutOfBoundsException();
		}
		return current.getValue();
	}

}
