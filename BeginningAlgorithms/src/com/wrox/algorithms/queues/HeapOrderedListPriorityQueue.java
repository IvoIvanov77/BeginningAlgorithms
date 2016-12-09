package com.wrox.algorithms.queues;

import java.util.Comparator;

import com.wrox.algorithms.lists.*;

public class HeapOrderedListPriorityQueue<T> implements Queue<T> {
	
	private final List<T> list;
	private final Comparator<T> comparator;

	public HeapOrderedListPriorityQueue(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator cannot be null";
		this.comparator = comparator;
		this.list = new ArrayList<>();
	}

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
