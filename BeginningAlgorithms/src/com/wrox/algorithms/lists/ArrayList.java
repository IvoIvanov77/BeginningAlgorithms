package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.ArrayIterator;
import com.wrox.algorithms.iteration.Iterator;

public class ArrayList<T> implements List<T> {
	
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	private final int initialCapacity;
	private T[] array;
	private int size;
	
	public ArrayList() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public ArrayList(int initialCapacity) {
		assert initialCapacity > 0;
		this.initialCapacity = initialCapacity;
		clear();
	}
	
	public ArrayList(T[] array){
		assert !array.equals(null): "array can’t be null";
		this.initialCapacity = array.length;
		clear();
		System.arraycopy(array, 0, this.array, 0, array.length);
		this.size = array.length;
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return  new ArrayIterator<T>(array, 0, size);
	}

	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		assert !value.equals(null): "value can’t be null";
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException();
		}
		ensureCapacity(this.size + 1);
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = value;
		size ++;
	}
	
	private void ensureCapacity(int capacity){
		assert capacity > 0 : "capacity must be > 0";
		if(this.array.length < capacity){
			@SuppressWarnings("unchecked")
			T[] copy = (T[])new Object[capacity + capacity / 2];
			System.arraycopy(array, 0, copy, 0, this.size);
			this.array = copy;
		}
	}

	@Override
	public void add(T value) {
		insert(size, value);
		
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		T value = array[index];
		int copyFromIndex = index + 1;
		if(copyFromIndex < this.size){
			System.arraycopy(array, copyFromIndex, array, index, 
					this.size - copyFromIndex);
		}
		
		array[--size] = null;
		return value;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		int index = indexOf(value);
		if(index != -1){
			delete(index);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.array = (T[])new Object[this.initialCapacity];
		this.size = 0;
		
	}

	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		assert !value.equals(null): "value can’t be null";
		checkOutOfBounds(index);
		T oldValue = array[index];
		array[index] = value;
		return oldValue;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkOutOfBounds(index);
		return array[index];
	}

	private void checkOutOfBounds(int index) {
		if(isOutOfBounds(index)){
			throw new IndexOutOfBoundsException();
		}
	}
	
	private boolean isOutOfBounds(int index){
		return index < 0 || index >= size;
	}

	@Override
	public int indexOf(T value) {
		assert !value.equals(null): "value can’t be null";
		for (int i = 0; i < array.length; i++) {
			if(value.equals(array[i])){
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return indexOf(value) != -1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}
	
	@Override
	public String toString() {
		return ListUtil.toString(this);
	}

	
}
