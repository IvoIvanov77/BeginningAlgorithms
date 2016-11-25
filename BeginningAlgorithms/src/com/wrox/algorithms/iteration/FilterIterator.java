package com.wrox.algorithms.iteration;

public class FilterIterator<T> implements Iterator<T> {

	private final Iterator<T> iterator;
	private final Predicate predicate;

	public FilterIterator(Iterator<T> iterator, Predicate predicate) {

		assert iterator != null : "iterator can’t be null";
		assert predicate != null : "predicate can’t be null";
		this.iterator = iterator;
		this.predicate = predicate;
	}

	@Override
	public void first() {
		this.iterator.first();
		filterForwards();

	}

	@Override
	public void last() {
		this.iterator.last();
		filterBackwards();

	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.iterator.isDone();
	}

	@Override
	public void next() {
		this.iterator.next();
		filterForwards();

	}

	@Override
	public void previous() {
		this.iterator.previous();
		filterBackwards();

	}

	@Override
	public T current() throws IteratorOutOfBoundsException {

		return iterator.current();
	}

	private void filterForwards() {
		while (!iterator.isDone() && !predicate.evaluate(iterator.current())) {
			iterator.next();
		}
	}
	
	private void filterBackwards() {
		while (!iterator.isDone() && !predicate.evaluate(iterator.current())) {
			iterator.previous();
		}
	}

}
