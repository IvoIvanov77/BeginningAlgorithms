package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

public class LinkedList<T> implements List<T> {
	
	private final Element<T> headAndTail = new Element<>(null);
	private int size;
	
	public LinkedList() {
		clear();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ValueIterator();
	}

	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		assert !value.equals(null): "value can’t be null";
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException();			
		}
		Element<T> element = new Element<T>(value);
		element.attachBefore(getElement(index));
		size ++;
		
	}

	private Element<T> getElement(int index) {
		int middle = this.size / 2;
		if(index < middle){
			return getElementForwards(index);
		}else {
			return getElementBackwards(index);
		}
	}
	
	private Element<T> getElementForwards(int index){
		Element<T> current = this.headAndTail.next;
		for (int i = index; i > 0; i--) {
			current = current.getNext();
		}
		return current;
	}
	
	private Element<T> getElementBackwards(int index){
		Element<T> current = this.headAndTail;
		for (int i = this.size - index; i > 0; i--) {
			current = current.getPrevious();
		}
		return current;
	}

	@Override
	public void add(T value) {
		insert(this.size, value);
		
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		checkOutOfBounds(index);
		Element<T> element = getElement(index);
		element.detach();
		size --;
		return element.getValue();
	}

	@Override
	public boolean delete(T value) {
		assert value != null : "value can’t be null";		
		Element<T> current = this.headAndTail.getNext();
		while(current != this.headAndTail){
			if(value.equals(current.getValue())){
				current.detach();
				size --;
				return true;
			}
			current = current.getNext();			
		}
		return false;
	}

	@Override
	public void clear() {
		headAndTail.setNext(headAndTail);
		headAndTail.setPrevious(headAndTail);
		this.size = 0;
		
	}

	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		assert !value.equals(null): "value can’t be null";
		checkOutOfBounds(index);
		Element<T> element = getElement(index);
		T oldValue = element.getValue();
		element.setValue(value);
		return oldValue;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		checkOutOfBounds(index);		
		return getElement(index).getValue();
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
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		int index = 0;
		Element<T> current = this.headAndTail.getNext();
		while(current != this.headAndTail){
			if(value.equals(current.getValue())){
				return index;
			}
			current = current.getNext();
			index ++;
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
	
	public T getHead(){
		return this.headAndTail.getNext().getValue();
	}
	
	public T getTail(){
		return this.headAndTail.getPrevious().getValue();
	}



	private static final class Element<T> {
		private T value;
		private Element<T> next;
		private Element<T> previous;
		
		public Element(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Element<T> getNext() {
			return next;
		}

		public void setNext(Element<T> next) {
			this.next = next;
		}

		public Element<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Element<T> previous) {
			this.previous = previous;
		}
		
		public void attachBefore(Element<T> next){
			assert next != null : "next can’t be null";
			Element<T> previous = next.previous;
			
			setNext(next);
			setPrevious(previous);
			
			previous.setNext(this);
			next.setPrevious(this);
		}
		
		public void detach(){
			this.previous.setNext(this.next);
			this.next.setPrevious(this.previous);
		}
		
	}
	
	private final class ValueIterator implements Iterator<T>{
		
		private Element<T> current = headAndTail;

		@Override
		public void first() {
			current = headAndTail.getNext();
			
		}

		@Override
		public void last() {
			current = headAndTail.getPrevious();
			
		}

		@Override
		public boolean isDone() {
			// TODO Auto-generated method stub
			return current == headAndTail;
		}

		@Override
		public void next() {
			current = current.getNext();
			
		}

		@Override
		public void previous() {
			current = current.getPrevious();
			
		}

		@Override
		public T current() throws IteratorOutOfBoundsException {
			// TODO Auto-generated method stub
			if (isDone()) {
				throw new IteratorOutOfBoundsException();
			}
			return current.getValue();
		}		
	}	
}
