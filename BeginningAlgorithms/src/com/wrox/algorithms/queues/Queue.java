package com.wrox.algorithms.queues;

public interface Queue<T> {
	
	public void enqueue(T value);
	public T dequeue() throws EmptyQueueException;
	public void clear();
	public int size();
	public boolean isEmpty();

}
