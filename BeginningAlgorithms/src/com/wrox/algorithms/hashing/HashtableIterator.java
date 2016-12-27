package com.wrox.algorithms.hashing;

import com.wrox.algorithms.iteration.*;
import com.wrox.algorithms.iteration.Iterable;


public class HashtableIterator<T> implements Iterator<T>{
	
	private final Iterator<Iterable<T>> buckets;
    private Iterator<T> values = new EmptyIterator<>();
    
    

	public HashtableIterator(Iterator<Iterable<T>> buckets) {
		assert buckets != null : "buckets can't be null";
		this.buckets = buckets;
		
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		this.buckets.first();
		this.values = new EmptyIterator<>();
		next();
		
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		this.buckets.last();
		this.values = new EmptyIterator<>();
		previous();
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.values.isDone() && this.buckets.isDone();
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		for(this.values.next(); this.values.isDone() && !this.buckets.isDone();
				this.buckets.next()){
			Iterable<T> bucket = this.buckets.current();
			if(bucket != null){
				this.values = bucket.iterator();
				this.values.first();
			}
		}
		
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		for(this.values.previous(); this.values.isDone() && !this.buckets.isDone();
				this.buckets.previous()){
			Iterable<T> bucket = this.buckets.current();
			if(bucket != null){
				this.values = bucket.iterator();
				this.values.last();
			}
		}		
	}

	@Override
	public T current() throws IteratorOutOfBoundsException {
		if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return values.current();

	}

}
