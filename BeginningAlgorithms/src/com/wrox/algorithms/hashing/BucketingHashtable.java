package com.wrox.algorithms.hashing;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.*;

public class BucketingHashtable<T> implements Hashtable<T> {
	
	private final float loadFactor;
	@SuppressWarnings("rawtypes")
	private List[] buckets;
	private int size;

	public BucketingHashtable(int capacity, float loadFactor) {
		// TODO Auto-generated constructor stub
		assert capacity > 0 : "initialCapacity can’t be < 1";
		assert loadFactor > 0 : "loadFactor can’t be <= 0";
		
		this.loadFactor = loadFactor;
		this.buckets = new List[capacity];
		
	}

	@Override
	public void add(T value) {
		// TODO Auto-generated method stub
		List<T> bucket = bucketFor(value);
		
		if(!bucket.contains(value)){
			bucket.add(value);
			this.size ++;
			maintainLoad();
		}

	}	

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<T> bucket = this.buckets[bucketIndexFor(value)];
		return bucket != null && bucket.contains(value);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	private void maintainLoad() {
		// TODO Auto-generated method stub
		if(this.size > this.buckets.length * this.loadFactor){
			resize();
		}
		
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		// TODO Auto-generated method stub
		BucketingHashtable<T> copy = new BucketingHashtable<>(this.buckets.length * 2,
				loadFactor);
		for (int i = 0; i < buckets.length; i++) {
			if(this.buckets[i] != null){
				copy.addAll(this.buckets[i].iterator());
			}
		}
		this.buckets = copy.buckets;
	}

	private void addAll(Iterator<T> i) {
		// TODO Auto-generated method stub
		assert i != null : "iterator can’t be null";
		for(i.first(); !i.isDone(); i.next()){
			add(i.current());
		}
		
	}

	private List<T> bucketFor(T value) {
		// TODO Auto-generated method stub
		int bucketIndex = bucketIndexFor(value);
		
		@SuppressWarnings("unchecked")
		List<T> bucket = this.buckets[bucketIndex];
		if(bucket == null){
			bucket = new LinkedList<>();
			this.buckets[bucketIndex] = bucket;
		}
		return bucket;
	}

	private int bucketIndexFor(T value) {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		return value.hashCode() % this.buckets.length;
	}

}
