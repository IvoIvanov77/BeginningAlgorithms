package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class ArrayIteratorTest extends TestCase {
	
	public void testIterationRespectsBounds(){
		String[] array = {"A", "B", "C", "D", "E", "F"};
		Iterator<String> iterator = new ArrayIterator<String>(array, 1, 3);
		
		iterator.first();		
		assertFalse(iterator.isDone());
		assertSame(array[1], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(array[2], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(array[3], iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
			
		}
	}
	
	public void testBackwardsIteration(){
		
		Object[] array = {"A", "B", "C"};
		Iterator<Object> iterator = new ArrayIterator<Object>(array);
		
		iterator.last();		
		assertFalse(iterator.isDone());
		assertSame(array[2], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(array[1], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(array[0], iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
			
		}
	}

}
