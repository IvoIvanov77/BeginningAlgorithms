package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

import junit.framework.TestCase;

public abstract class AbstractListTestCase extends TestCase {
	
	protected static final String VALUE_A = "A";
	protected static final String VALUE_B = "B";
	protected static final String VALUE_C = "C";
	
	protected abstract List<String> createList();
	
	public void testInsertIntoEmptyList(){
		List<String> list = createList();
		
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		list.insert(0, VALUE_A);
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertSame(list.get(0), VALUE_A);
	}
	
	public void testInsertBetweenElements(){
		List<String> list = createList();
		
		list.insert(0, VALUE_A);
		list.insert(1, VALUE_B);
		list.insert(1, VALUE_C);
		
		assertEquals(3, list.size());
		
		assertSame(list.get(0), VALUE_A);
		assertSame(list.get(1), VALUE_C);
		assertSame(list.get(2), VALUE_B);
		
	}
	
	public void testInsertBeforeFirstElement(){
		List<String> list = createList();
		
		list.insert(0, VALUE_A);
		list.insert(0, VALUE_B);		
		
		assertEquals(2, list.size());
		
		assertSame(list.get(0), VALUE_B);
		assertSame(list.get(1), VALUE_A);		
	}
	
	public void testInsertAfterLastElement(){
		List<String> list = createList();
		
		list.insert(0, VALUE_A);
		list.insert(1, VALUE_B);		
		
		assertEquals(2, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));	
	}
	
	public void testInsertOutOfBounds(){
		List<String> list = createList();
		
		try {
			list.insert(-1, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
		
		try {
			list.insert(1, VALUE_B);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	public void testAdd(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_C);
		list.add(VALUE_B);
		
		assertEquals(3, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_C, list.get(1));
		assertSame(VALUE_B, list.get(2));
	}
	
	public void testSet(){		
		List<String> list = createList();
		
		list.add(VALUE_A);
		assertSame(VALUE_A, list.get(0));
		
		assertSame(VALUE_A, list.set(0, VALUE_B));		
		assertSame(VALUE_B, list.get(0));
		
	}
	
	public void testGetOutOfBounds(){
		List<String> list = createList();
		
		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
		
		try {
			list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
		
		list.add(VALUE_A);
		
		try {
			list.get(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	public void testSetOutOfBounds(){
		List<String> list = createList();
		
		try {
			list.set(-1, VALUE_A);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
		
		try {
			list.set(0, VALUE_B);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
		
		list.insert(0, VALUE_C);;
		
		try {
			list.set(1, VALUE_C);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	public void testDeleteOnlyElement(){
		List<String> list = createList();
		
		list.add(VALUE_A);		
		assertEquals(1, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_A, list.delete(0));
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
	}
	
	public void testDeleteFirstElement(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(3, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_C, list.get(2));
		
		assertSame(VALUE_A, list.delete(0));
		assertSame(VALUE_B, list.get(0));
		assertSame(VALUE_C, list.get(1));
	}
	
	public void testDeleteLastElement(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(3, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_C, list.get(2));
		
		assertSame(VALUE_C, list.delete(2));
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
	}
	
	public void testDeleteMiddleElement(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(3, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_C, list.get(2));
		
		assertSame(VALUE_B, list.delete(1));
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_C, list.get(1));
	}
	
	public void testDeleteOutOfBounds(){
		List<String> list = createList();
		
		try {
			list.delete(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block			
		}
		
		try {
			list.delete(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block			
		}
	}
	
	public void testDeleteByValue(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		assertEquals(3, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertSame(VALUE_A, list.get(2));
		
		assertTrue(list.delete(VALUE_A));
		assertEquals(2, list.size());		
		assertSame(VALUE_B, list.get(0));
		assertSame(VALUE_A, list.get(1));
		
		assertTrue(list.delete(VALUE_A));
		assertEquals(1, list.size());		
		assertSame(VALUE_B, list.get(0));
		
		assertFalse(list.delete(VALUE_C));
		
		assertEquals(1, list.size());		
		assertSame(VALUE_B, list.get(0));
		
		assertTrue(list.delete(VALUE_B));
		assertEquals(0, list.size());			
	}
	
	public void testEmptyIteration(){
		List<String> list = createList();
		
		Iterator<String> iterator = list.iterator();
		
		assertTrue(iterator.isDone());
		
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// TODO Auto-generated catch block			
		}
	}
	
	public void testForwardIteration(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		Iterator<String> iterator = list.iterator();
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// TODO Auto-generated catch block			
		}
	}
	
	public void testReverseIteration(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		Iterator<String> iterator = list.iterator();
		
		iterator.last();
		assertFalse(iterator.isDone());
		assertSame(VALUE_C, iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(VALUE_B, iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertSame(VALUE_A, iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// TODO Auto-generated catch block			
		}
	}
	
	public void testIndexOf(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		assertSame(0, list.indexOf(VALUE_A));
		assertSame(1, list.indexOf(VALUE_B));
		assertSame(-1, list.indexOf(VALUE_C));
	}
	
	public void testContains(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_A);
		
		assertTrue(list.contains(VALUE_A));
		assertTrue(list.contains(VALUE_B));
		assertFalse(list.contains(VALUE_C));
	}
	
	public void testClear(){
		List<String> list = createList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_B);
		
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());
		
		list.clear();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

}
