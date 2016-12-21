package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;
import com.wrox.algorithms.iteration.ReverseIterator;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public abstract class AbstractSetTestCase extends TestCase{
	
	private static final String A = "a";
	private static final String B = "b";
	private static final String C = "c";
	private static final String D = "d";
	private static final String E = "e";
	private static final String F = "f";
	
	private Set<String> set;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.set = createSet();
		set.add(A);
		set.add(B);
		set.add(C);
		set.add(D);
	}

	protected abstract Set<String> createSet(); 
	
	public void testContainsExisting(){	
		assertTrue(this.set.contains(A));
		assertTrue(this.set.contains(B));
		assertTrue(this.set.contains(C));
		assertTrue(this.set.contains(D));
	}
	
	public void testContainsNotExisting(){	
		
		assertFalse(this.set.contains(E));
		assertFalse(this.set.contains(F));		
	}
	
	public void testAddNewValue(){
		
		assertEquals(4, set.size());
		
		set.add(E);
		assertEquals(5, set.size());
		assertTrue(this.set.contains(E));
		
		set.add(F);
		assertEquals(6, set.size());
		assertTrue(this.set.contains(F));
	}
	
	public void testAddExistingValueHasNoEffect(){
		
		assertEquals(4, set.size());
		assertFalse(set.add(C));
		assertEquals(4, set.size());
	}
	
	public void testDeleteExisting(){
		
		assertTrue(set.delete(B));
		assertFalse(set.contains(B));
		assertEquals(3, set.size());
		
		assertTrue(set.delete(A));
		assertFalse(set.contains(A));
		assertEquals(2, set.size());
		
		assertTrue(set.delete(C));
		assertFalse(set.contains(C));
		assertEquals(1, set.size());
		
		assertTrue(set.delete(D));
		assertFalse(set.contains(D));
		assertEquals(0, set.size());
	}
	
	public void testDeleteNonExisting(){
		
		assertEquals(4, set.size());
		assertFalse(set.delete(E));
		assertEquals(4, set.size());
		assertFalse(set.delete(F));
		assertEquals(4, set.size());
	}
	
	public void testClear(){
		
		assertEquals(4, set.size());
		assertFalse(set.isEmpty());
		
		set.clear();
		
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());
		
		assertFalse(set.contains(A));
		assertFalse(set.contains(B));
		assertFalse(set.contains(C));
		assertFalse(set.contains(D));
	}
	
	public void testIteratorForwards() {
		checkIterator(set.iterator());
	}
	
	

	public void testIteratorBackwards() {
		checkIterator(new ReverseIterator<String>(set.iterator()));
	}
	
	private void checkIterator(Iterator<String> i) {
		// TODO Auto-generated method stub
		List<String> values = new LinkedList<>();
		
		for(i.first(); !i.isDone(); i.next()){
			values.add(i.current());
		}
		
		try {
			i.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {			
			
		}
		
		assertEquals(4, values.size());
		assertTrue(values.contains(A));
		assertTrue(values.contains(B));
		assertTrue(values.contains(C));
		assertTrue(values.contains(D));
	}

}
