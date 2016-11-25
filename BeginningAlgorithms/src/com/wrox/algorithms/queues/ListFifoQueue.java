package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

public class ListFifoQueue<T> implements Queue<T> {
	
	private final List<T> list;
	
	public ListFifoQueue(List<T> list) {
		assert !list.equals(null): "list can’t be null";
		this.list = list;
	}
	
	public ListFifoQueue() {
		this(new LinkedList<>());
	}

	@Override
	public void enqueue(T value) {
		list.add(value);
		
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return list.delete(0);
	}

	@Override
	public void clear() {
		list.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	
}
