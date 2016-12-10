package com.wrox.algorithms.stacks;

import java.util.Comparator;

import com.wrox.algorithms.queues.*;


public class PriorityQueueStack<T> implements Stack<T> {
	
	private final Queue<T> queue;
	private final Comparator<T> comparator;

	public PriorityQueueStack() {	
		this.comparator = new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return 1;
			}
		};
		this.queue = new UnsortedListPriorityQueue<>(comparator);
	}

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub
		this.queue.enqueue(value);
		
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(this.queue.isEmpty()){
			throw new EmptyQueueException();
		}
		return this.queue.dequeue();
	}

	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		this.enqueue(value);
	}

	@Override
	public T pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(this.queue.isEmpty()){
			throw new EmptyStackException();
		}
		return this.dequeue();
	}

	@Override
	public T peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(this.queue.isEmpty()){
			throw new EmptyStackException();
		}
		T top = this.dequeue();
		this.enqueue(top);
		return top;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.queue.clear();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.queue.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.queue.isEmpty();
	}

}
