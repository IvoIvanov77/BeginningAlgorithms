package com.wrox.algorithms.stacks;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.queues.EmptyQueueException;

public  class ListStack<T> implements Stack<T> {
	
	private final List<T> list = new LinkedList<>();

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub
		push(value);
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		try {
			return pop();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	@Override
	public void push(T value) {
		this.list.add(value);
		
	}

	@Override
	public T pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return this.list.delete(size() - 1);
	}

	@Override
	public T peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return this.list.get(size() - 1);
	}

	@Override
	public void clear() {
		this.list.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.list.isEmpty();
	}
	
	
}
