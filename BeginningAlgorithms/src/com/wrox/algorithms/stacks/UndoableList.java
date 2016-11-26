package com.wrox.algorithms.stacks;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.List;

public class UndoableList<T> implements List<T> {
	
	private final Stack<UndoAction> undoStack = new ListStack<>();
	private final List<T> list;

	public UndoableList(List<T> list) {
		assert !list.equals(null): "list can’t be null";
		this.list = list;
	}
	
	private static interface UndoAction{
		public void exevute();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.list.iterator();
	}

	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		this.list.insert(index, value);
		this.undoStack.push(new UndoAction() {
			
			@Override
			public void exevute() {
				list.delete(index);
				
			}
		});
		
	}

	@Override
	public void add(T value) {
		// TODO Auto-generated method stub
		insert(size(), value);
		
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		T value = this.list.delete(index);
		this.undoStack.push(new UndoAction() {
			
			@Override
			public void exevute() {
				list.insert(index, value);
				
			}
		});
		return value;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		int index = this.list.indexOf(value);
		if(index == -1){			
			return false;
		}
		delete(index);
		return true;
	}

	@Override
	public void clear() {
		this.list.clear();
		this.undoStack.clear();
		
	}

	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		T oldValue = this.list.set(index, value);
		this.undoStack.push(new UndoAction() {
			
			@Override
			public void exevute() {
				list.set(index, oldValue);
				
			}
		});
		return oldValue;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
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

	public boolean canUndo() {
		// TODO Auto-generated method stub
		return !undoStack.isEmpty();
	}

	public void undo() {
		// TODO Auto-generated method stub
		this.undoStack.pop().exevute();
	}

	

}
