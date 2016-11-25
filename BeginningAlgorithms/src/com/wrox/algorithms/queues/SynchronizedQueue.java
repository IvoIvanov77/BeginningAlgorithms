package com.wrox.algorithms.queues;

public class SynchronizedQueue<T> implements Queue<T> {
	
	private final Object mutex = new Object();
	private final Queue<T> queue;
	
	
	public SynchronizedQueue(Queue<T> q) {
		assert q != null : "queue can’t be null";		
		this.queue = q;		
	}	
	

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub
		synchronized (mutex) {			
			this.queue.enqueue(value);			
		}		
	}
	

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		synchronized (mutex) {								
			return  queue.dequeue();
		}
	}

	@Override
	public void clear() {
		synchronized (mutex) {
			this.queue.clear();			
		}		
	}

	@Override
	public int size() {
		synchronized (mutex) {
			return this.queue.size();			
		}		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		synchronized (mutex) {
			return this.queue.isEmpty();
		}		
	}

}
