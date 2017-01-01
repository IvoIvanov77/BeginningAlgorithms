package com.wrox.algorithms.maps;

import com.wrox.algorithms.hashing.HashtableIterator;
import com.wrox.algorithms.iteration.ArrayIterator;
import com.wrox.algorithms.iteration.Iterator;


public class HashMap<K, V> implements Map<K, V> {
	
	public static final int DEFAULT_CAPACITY = 17;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;	
	private final int initialCapacity;
	private final float loadFactor;
	private ListMap<K, V>[] buckets;
	private int size;
	
	public HashMap() {		
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	
	public HashMap(int initialCapacity) {
		
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}
	

	public HashMap(int initialCapacity, float loadFactor) {
		assert initialCapacity > 0 : "initialCapacity can’t be < 1";
		assert loadFactor > 0 : "loadFactor can’t be <= 0";
		
		this.initialCapacity = initialCapacity;
		this.loadFactor = loadFactor;
		clear();
	}

	@Override
	public Iterator<Map.Entry<K, V>> iterator() {
		// TODO Auto-generated method stub
		return  new HashtableIterator<Map.Entry<K, V>>(new ArrayIterator<>(this.buckets));
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		ListMap<K, V> bucket = this.buckets[bucketIndexFor(key)];
		return bucket != null ? bucket.get(key) : null;		
	}

	@Override
	public V set(K key, V value) {
		ListMap<K, V> bucket = bucketFor(key);
		int sizeBefore = bucket.size();
		V oldValue = bucket.set(key, value);
		if(bucket.size() > sizeBefore){
			this.size ++;
			maintainLoad();
		}
		
		return oldValue;
	}

	@Override
	public V delete(K key) {
		// TODO Auto-generated method stub
		int index = bucketIndexFor(key);
		ListMap<K, V>  bucket = this.buckets[index];
		if(bucket == null){
			return null;
		}
		V value = bucket.delete(key);
		if(value != null){
			this.size --;
		}
		return value;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return get(key) != null;
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

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.buckets = new ListMap[initialCapacity];
		this.size = 0;
	}
	
	private int bucketIndexFor(K key) {
		// TODO Auto-generated method stub
		assert key != null : "key can’t be null";
		return Math.abs(key.hashCode() % this.buckets.length);
	}
	
	private ListMap<K, V> bucketFor(K key) {
		// TODO Auto-generated method stub
		int index = bucketIndexFor(key);
		ListMap<K, V> bucket = this.buckets[index];
		if(bucket == null){
			bucket = new ListMap<>();
			this.buckets[index] = bucket;
		}
		return bucket;
	}
	
	private void maintainLoad() {
		// TODO Auto-generated method stub
		if(this.size > this.buckets.length * this.loadFactor){
			resize();
		}
		
	}


	private void resize() {
		// TODO Auto-generated method stub
		HashMap<K, V> copy = new HashMap<>(this.buckets.length * 2, this.loadFactor);
		for(ListMap<K, V> bucket : this.buckets){
			if(bucket != null){
				copy.addAll(bucket.iterator());
			}
		}
		this.buckets = copy.buckets;
	}


	private void addAll(Iterator<Map.Entry<K, V>> i) {
		// TODO Auto-generated method stub
		assert i != null : "entries can’t be null";
		
		for(i.first(); !i.isDone(); i.next()){			
			set(i.current().getKey(), i.current().getValue());			
		}
	}

	

}
