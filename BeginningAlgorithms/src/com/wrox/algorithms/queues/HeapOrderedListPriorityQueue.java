package com.wrox.algorithms.queues;

import java.util.Comparator;

import com.wrox.algorithms.lists.*;

public class HeapOrderedListPriorityQueue<T> implements PriorityQueue<T> {

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
		list.add(value);
		swim(list.size() - 1);
	}

	private void swim(int index) {
		// TODO Auto-generated method stub
		if (index == 0) {
			return;
		}
		int parent = (index - 1) / 2;
		if (comparator.compare(list.get(index), list.get(parent)) > 0) {
			swap(index, parent);
			swim(parent);
		}
	}

	private void swap(int index, int parent) {
		// TODO Auto-generated method stub
		T temp = list.get(index);
		list.set(index, list.get(parent));
		list.set(parent, temp);
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		T result = list.get(0);
		if (list.size() > 1) {
			list.set(0, list.get(list.size() - 1));
			sink(0);
		}
		list.delete(list.size() - 1);
		return result;
	}

	private void sink(int index) {
		// TODO Auto-generated method stub
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		if (left >= list.size()) {
			return;
		}
		int largestChild = left;
		if (right < list.size()) {
			if (comparator.compare(list.get(left), list.get(right)) < 0) {
				largestChild = right;
			}
		}
		if (comparator.compare(list.get(index), list.get(largestChild)) < 0) {
			swap(index, largestChild);
			sink(largestChild);
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
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
