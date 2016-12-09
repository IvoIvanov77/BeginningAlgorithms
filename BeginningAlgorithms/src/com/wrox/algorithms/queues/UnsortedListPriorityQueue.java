package com.wrox.algorithms.queues;

import java.util.Comparator;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

public class UnsortedListPriorityQueue<T> implements Queue<T> {
	
	private final List<T> list;
	private final Comparator<T> comparator;

	public UnsortedListPriorityQueue(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator cannot be null";
		this.comparator = comparator;
		this.list = new LinkedList<>();
	}

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub
		this.list.add(value);

	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new EmptyQueueException();
		}
		return this.list.delete(getIndexOfLargestElement());
	}

	private int getIndexOfLargestElement() {
		// TODO Auto-generated method stub
		int result = 0;
		for (int i = 1; i < list.size(); i++) {
			if(comparator.compare(list.get(i), list.get(result))> 0){
				result = i;
			}
		}
		return result;
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
