package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.Iterable;

public interface Set<T>  extends Iterable<T>{
	
	public boolean add(T value);
	public boolean delete(T value);
	public boolean contains(T value);
	public void clear();
	public int size();
	public boolean isEmpty();

}
