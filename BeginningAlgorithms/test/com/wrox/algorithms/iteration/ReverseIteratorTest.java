package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class ReverseIteratorTest extends TestCase{
	
	private static final String[] ARRAY = {"A", "B", "C"};
	
	public void testForwardsIterationBecomesBackwards(){
		
		ReverseIterator<String> iterator = 
				new ReverseIterator<String>(new ArrayIterator<String>(ARRAY));
		
		iterator.first();		
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
			
		}
	}
	
public void testForwardsIterationBecomesForwards(){
		
		ReverseIterator<?> iterator = 
				new ReverseIterator<String>(new ArrayIterator<String>(ARRAY));
		
		iterator.last();		
		assertFalse(iterator.isDone());
		assertSame(ARRAY[0], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[1], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(ARRAY[2], iterator.current());
		
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
