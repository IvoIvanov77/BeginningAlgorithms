package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterator;

public class EmptyMap<K, V> implements Map<K, V>{

	@Override
	public Iterator<Map.Entry<K, V>> iterator() {
		// TODO Auto-generated method stub
		return new EmptyIterator<>();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public V delete(K key) {
		// TODO Auto-generated method stub
		 throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
