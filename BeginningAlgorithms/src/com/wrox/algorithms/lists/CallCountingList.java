package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;

public class CallCountingList<T> implements List<T> {
	
	private final List<T> list;	
	
	private int insertCount;
    private int addCount;
    private int deleteCount;
    private int getCount;
    private int setCount;


	public CallCountingList(List<T> list) {		
		this.list = list;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.list.iterator();
	}

	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		insertCount ++;
		this.list.insert(index, value);
		
	}

	@Override
	public void add(T value) {
		// TODO Auto-generated method stub
		addCount ++;
		this.list.add(value);
		
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		deleteCount ++;
		return this.list.delete(index);
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		deleteCount ++;
		return this.delete(value);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.list.clear();
		
	}

	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		setCount ++;
		return this.list.set(index, value);
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		getCount ++;
		return this.list.get(index);
	}

	@Override
	public int indexOf(T value) {
		// TODO Auto-generated method stub
		return this.list.indexOf(value);
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return this.list.contains(value);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.list.isEmpty();
	}
	
	public String toString() {
        return new StringBuffer("Call-counting List: ")
                .append("add: " + addCount)
                .append(" insert: " + insertCount)
                .append(" delete: " + deleteCount)
                .append(" set: " + setCount)
                .append(" get: " + getCount).toString();
    }


}
