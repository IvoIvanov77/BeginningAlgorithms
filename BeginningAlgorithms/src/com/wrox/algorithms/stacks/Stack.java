package com.wrox.algorithms.stacks;

import com.wrox.algorithms.queues.Queue;

public interface Stack<T> extends Queue<T> {
	
	public void push(T value);
	public T pop() throws EmptyStackException;
	public T peek() throws EmptyStackException;
	public void clear();
	public int size();
	public boolean isEmpty();

}
