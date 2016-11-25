package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class FilterIteratorTest extends TestCase {

	private static final Object[] ARRAY = { "A", "B", "C" };

	private static final class DummyPredicate implements Predicate {

		private final Iterator<Object> iterator;
		private final boolean result;

		public DummyPredicate(boolean result, Iterator<Object> iterator) {
			this.iterator = iterator;
			this.result = result;
			iterator.first();
		}

		@Override
		public boolean evaluate(Object object) {
			assertSame(iterator.current(), object);
			iterator.next();
			return result;
		}

	}

	public void testForwardsIterationIncludesItemsWhenPredicateReturnsTrue() {

		Iterator<Object> expectedIterator = new ArrayIterator<Object>(ARRAY);
		Iterator<Object> underlyingIterator = new ArrayIterator<Object>(ARRAY);

		Iterator<Object> iterator = new FilterIterator<Object>
		(underlyingIterator, new DummyPredicate(true, expectedIterator));

		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());

		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());

		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());

		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());
	}

	public void testForwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
		Iterator<Object> expectedIterator = new ArrayIterator<Object>(ARRAY);
		Iterator<Object> underlyingIterator = new ArrayIterator<Object>(ARRAY);
		Iterator<Object> iterator = new FilterIterator<Object>
		(underlyingIterator, new DummyPredicate(false, expectedIterator));

		iterator.first();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());
	}

	public void testBackwardssIterationIncludesItemsWhenPredicateReturnsTrue() {
		Iterator<Object> expectedIterator = new ReverseIterator<Object>
		(new ArrayIterator<Object>(ARRAY));
		Iterator<Object> underlyingIterator = new ArrayIterator<Object>(ARRAY);
		Iterator<Object> iterator = new FilterIterator<Object>
		(underlyingIterator, new DummyPredicate(true, expectedIterator));
		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());
		iterator.previous();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());
	}

	public void testBackwardsIterationExcludesItemsWhenPredicateReturnsFalse() {
		Iterator<Object> expectedIterator = new ReverseIterator<Object>
		(new ArrayIterator<Object>(ARRAY));
		Iterator<Object> underlyingIterator = new ArrayIterator<Object>(ARRAY);
		Iterator<Object> iterator = new FilterIterator<Object>
		(underlyingIterator, new DummyPredicate(false, expectedIterator));
		iterator.last();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
		}
		assertTrue(expectedIterator.isDone());
		assertTrue(underlyingIterator.isDone());
	}

}
