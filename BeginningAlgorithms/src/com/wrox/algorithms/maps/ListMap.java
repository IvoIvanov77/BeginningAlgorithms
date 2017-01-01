package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.*;

public class ListMap<K, V> implements Map<K, V> {
	

	private List<Map.Entry<K, V>> entries = new LinkedList<>();

	@Override
	public Iterator<Map.Entry<K, V>> iterator() {
		// TODO Auto-generated method stub
		return this.entries.iterator();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		DefaultEntry<K, V> entry = entryFor(key);
		return entry != null ? entry.getValue() : null;
	}	

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		DefaultEntry<K, V> entry = entryFor(key);
		if(entry != null){			
			return entry.setValue(value);
		}		
		this.entries.add(new DefaultEntry<>(key, value));
		return null;
	}

	@Override
	public V delete(K key) {
		// TODO Auto-generated method stub
		DefaultEntry<K, V> entry = entryFor(key);
		if(entry != null) {			
			this.entries.delete(entry);
			return entry.getValue();
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return entryFor(key) != null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.entries.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.entries.isEmpty();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.entries.clear();
	}

	private DefaultEntry<K, V> entryFor(K key) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<K, V>> i = iterator();
		for(i.first(); !i.isDone(); i.next()){
			if(i.current().getKey().equals(key)){
				return (DefaultEntry<K, V>) i.current();
			}
		}
		return null;
	}
}
