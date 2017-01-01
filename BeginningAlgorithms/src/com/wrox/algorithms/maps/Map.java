package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterable;

public interface Map<K, V> extends Iterable<Map.Entry<K, V>> {
	
	
	public V get(K key);
	public V set(K key, V value);
	public V delete(K key);
	public boolean contains(K key);	
	public int size() ;
	public boolean isEmpty();
	public void clear();			


	public interface Entry<K, V> {
		
		public K getKey();
		public V getValue();
	}

}
