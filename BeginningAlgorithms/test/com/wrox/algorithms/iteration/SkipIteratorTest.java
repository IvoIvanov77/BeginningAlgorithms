package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class SkipIteratorTest extends TestCase {
	
	public void testForwardsIteration(){
		String[] array = {"A", "B", "C", "D", "E", "F"};
		Iterator<String> iterator = new ArrayIterator<String>(array);
		Iterator<String> skipIterator = new SkipIterator<>(iterator, 2);
		
		skipIterator.first();		
		assertFalse(skipIterator.isDone());
		assertSame(array[1], skipIterator.current());
		
		skipIterator.next();
		assertFalse(skipIterator.isDone());
		assertSame(array[3], skipIterator.current());
		
		skipIterator.next();
		assertFalse(skipIterator.isDone());
		assertSame(array[5], skipIterator.current());
		
		skipIterator.next();
		assertTrue(iterator.isDone());
		try {
			skipIterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
			
		}
	}
	
	public void testBackwardsIteration(){
		
		String[] array = {"A", "B", "C", "D", "E", "F"};
		Iterator<String> iterator = new ArrayIterator<String>(array);
		Iterator<String> skipIterator = new SkipIterator<>(iterator, 2);
		
		skipIterator.last();		
		assertFalse(skipIterator.isDone());
		assertSame(array[4], skipIterator.current());
		
		skipIterator.previous();
		assertFalse(skipIterator.isDone());
		assertSame(array[2], skipIterator.current());
		
		skipIterator.previous();
		assertFalse(skipIterator.isDone());
		assertSame(array[0], skipIterator.current());
		
		skipIterator.previous();
		assertTrue(iterator.isDone());
		try {
			skipIterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
			
		}
	}

}
