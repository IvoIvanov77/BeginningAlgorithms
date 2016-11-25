package com.wrox.algorithms.queues;

public class BlockingQueue<T> implements Queue<T> {
	
	private final Object mutex = new Object();
	private final Queue<T> queue;
	private final int maxSize;
	
	public BlockingQueue(Queue<T> q, int size) {
		assert q != null : "queue can’t be null";
		assert size > 0 : "size can’t be < 1";
		this.queue = q;
		this.maxSize = size;
	}
	
	public BlockingQueue(Queue<T> q) {
		this(q, Integer.MAX_VALUE);
	}

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub
		synchronized (mutex) {
			while(size() == this.maxSize){
				waitForNotification();
			}
			this.queue.enqueue(value);
			mutex.notifyAll();
			
		}
		
	}

	private void waitForNotification() {
		// TODO Auto-generated method stub
		try {
			mutex.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		synchronized (mutex) {
			while(isEmpty()){
				waitForNotification();
			}
			T item = queue.dequeue();
			mutex.notifyAll();
			return item;
		}
	}

	@Override
	public void clear() {
		synchronized (mutex) {
			this.queue.clear();
			mutex.notifyAll();
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
