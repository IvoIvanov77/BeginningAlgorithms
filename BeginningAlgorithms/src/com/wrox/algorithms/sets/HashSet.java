package com.wrox.algorithms.sets;

import com.wrox.algorithms.hashing.HashtableIterator;
import com.wrox.algorithms.iteration.ArrayIterator;
import com.wrox.algorithms.iteration.Iterator;

public class HashSet<T> implements Set<T> {
	
	public static final int DEFAULT_CAPACITY = 17;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;	
	private final int initialCapacity;
	private final float loadFactor;
	private ListSet<T>[] buckets;
	private int size;
	
	public HashSet() {
		
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	
	public HashSet(int initialCapacity) {
		
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}
	

	public HashSet(int initialCapacity, float loadFactor) {
		assert initialCapacity > 0 : "initialCapacity can’t be < 1";
		assert loadFactor > 0 : "loadFactor can’t be <= 0";
		
		this.initialCapacity = initialCapacity;
		this.loadFactor = loadFactor;
		clear();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new HashtableIterator<T>(new ArrayIterator<>(this.buckets));
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		ListSet<T>  bucket = bucketFor(value);
		
		if(bucket.add(value)){
			this.size ++;
			maintainLoad();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		int index = bucketIndexFor(value);
		ListSet<T>  bucket = this.buckets[index];
		
		if(bucket != null && bucket.delete(value)){
			this.size --;
			if(bucket.isEmpty()){
				bucket = null;
			}
			return true;
		}
		
		return false;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		ListSet<T>  bucket = this.buckets[bucketIndexFor(value)];
		return bucket != null && bucket.contains(value);
	}	


	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.buckets = new ListSet[this.initialCapacity];
		this.size = 0;

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
	
	private int bucketIndexFor(T value) {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		return value.hashCode() % this.buckets.length;
	}
	
	private ListSet<T> bucketFor(T value) {
		// TODO Auto-generated method stub
		int index = bucketIndexFor(value);
		ListSet<T>  bucket = this.buckets[index];
		if(bucket == null){
			bucket = new ListSet<>();
			this.buckets[index] = bucket;
		}
		return bucket;
	}
	
	private void maintainLoad() {
		// TODO Auto-generated method stub
		if (loadFactorExceeded()) {
			resize();
		}
	}	

	private boolean loadFactorExceeded() {
		// TODO Auto-generated method stub
		return this.size > this.buckets.length * this.loadFactor;
	}
	
	private void resize() {
		// TODO Auto-generated method stub
		HashSet<T> copy = new HashSet<>(this.buckets.length * 2, this.loadFactor);
		for(ListSet<T> bucket : this.buckets){
			if(bucket != null){
				copy.addAll(bucket.iterator());
			}
		}
		this.buckets = copy.buckets;
	}


	private void addAll(Iterator<T> i) {
		// TODO Auto-generated method stub
		for(i.first(); !i.isDone(); i.next()){
			add(i.current());
		}
	}


}
