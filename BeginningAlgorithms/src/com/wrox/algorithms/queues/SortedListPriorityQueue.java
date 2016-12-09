package com.wrox.algorithms.queues;

import java.util.Comparator;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

public class SortedListPriorityQueue<T> implements Queue<T> {
	
	private final List<T> list;
	private final Comparator<T> comparator;

	public SortedListPriorityQueue(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator cannot be null";
		this.comparator = comparator;
		this.list = new LinkedList<>();
	}

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub
		int index = this.list.size();
		while(index > 0 && comparator.compare(list.get(index - 1), value) > 0){
			index --;
		}
		this.list.insert(index, value);

	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyQueueException();
		}
		return this.list.delete(list.size() - 1);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
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
