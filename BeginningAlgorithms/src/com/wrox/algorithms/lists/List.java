package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterable;
import com.wrox.algorithms.iteration.Iterator;

public interface List<T> extends Iterable<T> {

	public void insert(int index, T value) throws IndexOutOfBoundsException;

	public void add(T value);

	public T delete(int index) throws IndexOutOfBoundsException;

	public boolean delete(T value);

	public void clear();

	public T set(int index, T value) throws IndexOutOfBoundsException;

	public T get(int index) throws IndexOutOfBoundsException;

	public int indexOf(T value);

	public boolean contains(T value);

	public int size();

	public boolean isEmpty();

	@SuppressWarnings("unchecked")
	public default boolean isEqual(Object object) {

		return object.getClass().equals(this.getClass()) ? equals((List<T>) object) : false;
	}

	public default boolean equals(List<T> other) {
		if (other == null || other.size() != this.size()) {
			return false;
		}
		Iterator<T> i = iterator();
		Iterator<T> j = other.iterator();
		for (i.first(), j.first(); !i.isDone() && !j.isDone(); i.next(), j.next()) {
			if (!i.current().equals(j.current())) {
				break;
			}
		}
		return i.isDone() && j.isDone();
	}
		

}
