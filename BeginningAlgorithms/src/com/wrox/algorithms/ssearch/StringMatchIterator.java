package com.wrox.algorithms.ssearch;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

public class StringMatchIterator implements Iterator<StringMatch>{
	
	private final CharSequence text;
	private final StringSearcher searcher;
	private StringMatch current;
	
	

	public StringMatchIterator(CharSequence text, StringSearcher searcher) {
		assert searcher != null : "searcher can’t be null";
		assert text != null : "text can’t be null";
		this.text = text;
		this.searcher = searcher;	
	}

	@Override
	public void first() {
		// TODO Auto-generated method stub
		this.current = searcher.search(text, 0);
	}

	@Override
	public void last() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return current == null;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		if(!isDone()){			
			current = searcher.search(text, current.getIndex() + 1);
		}
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public StringMatch current() throws IteratorOutOfBoundsException {
		// TODO Auto-generated method stub
		if(isDone()){
			throw new IteratorOutOfBoundsException();
		}
		return this.current;
	}

}
