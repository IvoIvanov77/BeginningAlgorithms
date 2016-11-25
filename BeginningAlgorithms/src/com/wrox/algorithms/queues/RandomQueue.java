package com.wrox.algorithms.queues;

import java.util.Random;

import com.wrox.algorithms.lists.*;


public class RandomQueue<T> implements Queue<T> {
	
	private final List<T> list;
	
	public RandomQueue(List<T> list) {
		assert !list.equals(null): "list can’t be null";
		this.list = list;
	}
	
	public RandomQueue() {
		this(new LinkedList<>());
	}

	@Override
	public void enqueue(T value) {
		list.add(value);
		
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		Random rand = new Random();
		int index = rand.nextInt(list.size());
		return list.delete(index);
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
