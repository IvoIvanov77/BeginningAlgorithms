package com.wrox.algorithms.hashing;

public class LinearProbingHashtable<T> implements Hashtable<T> {
	
	private Object[] values;
	private int size;

	public LinearProbingHashtable(int capacity) {
		// TODO Auto-generated constructor stub
		assert capacity > 0 : "initialCapacity can’t be < 1";
		this.values = new Object[SimplePrimeNumberGenerator.INSTANCE.generate(capacity)];
	}

	@Override
	public void add(T value) {
		// TODO Auto-generated method stub
		ensureCapacityForOneMore();
		int index = indexFor(value);
		if(this.values[index] == null){
			this.values[index] = value;
			this.size ++;
		}

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
	
	private int indexOf(T value) {
		// TODO Auto-generated method stub
		int start = startIndexFor(value);
		int index = indexOf(value, start, this.values.length);
		if(index == -1){
			index = indexOf(value, 0, start);
		}
		return index;
	}
	
	private int indexOf(T value, int start, int end) {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		for (int i = start; i < end; i++) {
			if(value.equals(this.values[i])){
				return i;
			}
		}
		return -1;
	}

	private int indexFor(T value) {
		// TODO Auto-generated method stub
		int start = startIndexFor(value);
		int index = indexFor(value, start, this.values.length);
		if(index == -1){
			index = indexFor(value, 0, start);
			assert index != -1 : "no free slots";
		}
		return index;
	}

	private int indexFor(T value, int start, int end) {
		// TODO Auto-generated method stub
		for (int i = start; i < end; i++) {
			if(this.values[i] == null || value.equals(this.values[i])){
				return i;
			}
		}
		return -1;
	}

	private int startIndexFor(T value) {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		return value.hashCode() % this.values.length;
	}

	private void ensureCapacityForOneMore() {
		// TODO Auto-generated method stub
		if (size() == this.values.length) {
			resize();
		}
		
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		// TODO Auto-generated method stub
		int capacity = this.values.length * 2;
		LinearProbingHashtable<T> copy = new LinearProbingHashtable<>(capacity);
		for (int i = 0; i < values.length; i++) {
			if(!values[i].equals(null)){
				copy.add((T) values[i]);
			}
		}
		this.values = copy.values;
	}

}
