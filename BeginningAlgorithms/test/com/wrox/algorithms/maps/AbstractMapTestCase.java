package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.*;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public abstract class AbstractMapTestCase extends TestCase{
	
	private static final Map.Entry<String, String> A = new DefaultEntry<>("akey", "avalue");
	private static final Map.Entry<String, String> B = new DefaultEntry<>("bkey", "bvalue");
	private static final Map.Entry<String, String> C = new DefaultEntry<>("ckey", "cvalue");
	private static final Map.Entry<String, String> D = new DefaultEntry<>("dkey", "dvalue");
	private static final Map.Entry<String, String> E = new DefaultEntry<>("ekey", "evalue");
	private static final Map.Entry<String, String> F = new DefaultEntry<>("fkey", "fvalue");
	
	private Map<String, String> map;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.map = createMap();
		map.set(C.getKey(), C.getValue());
		map.set(A.getKey(), A.getValue());
		map.set(D.getKey(), D.getValue());
		map.set(B.getKey(), B.getValue());
	}

	protected abstract Map<String, String> createMap();
	
	public void testContainsExisting(){
		assertTrue(map.contains(A.getKey()));
		assertTrue(map.contains(B.getKey()));
		assertTrue(map.contains(C.getKey()));
		assertTrue(map.contains(D.getKey()));
	}
	
	public void testContainsNonExisting() {
		assertFalse(map.contains(E.getKey()));
		assertFalse(map.contains(F.getKey()));
	}
	
	public void testGetExisting(){
		assertSame(A.getValue(), map.get(A.getKey()));
		assertSame(B.getValue(), map.get(B.getKey()));
		assertSame(C.getValue(), map.get(C.getKey()));
		assertSame(D.getValue(), map.get(D.getKey()));
	}
	
	public void testGetNonExisting(){
		assertNull(map.get(E.getKey()));
		assertNull(map.get(F.getKey()));
	}
	
	public void testSetNewKey(){		
		assertEquals(4, map.size());
		
		assertNull(map.set(E.getKey(), E.getValue()));
		assertEquals(E.getValue(), map.get(E.getKey()));		
		assertEquals(5, map.size());
		
		assertNull(map.set(F.getKey(), F.getValue()));
		assertEquals(F.getValue(), map.get(F.getKey()));		
		assertEquals(6, map.size());		
	}
	
	public void testSetExistingKey(){
		assertEquals(4, map.size());
		
		assertEquals(C.getValue(), map.set(C.getKey(), "cvalue2"));
		assertEquals("cvalue2", map.get(C.getKey()));
		assertEquals(4, map.size());
	}
	
	public void testDeleteExisting(){
		assertEquals(4, map.size());
		
		assertEquals(B.getValue(), map.delete(B.getKey()));
		assertFalse(map.contains(B.getKey()));
		assertEquals(3, map.size());
		
		assertEquals(A.getValue(), map.delete(A.getKey()));
		assertFalse(map.contains(A.getKey()));
		assertEquals(2, map.size());
		
		assertEquals(C.getValue(), map.delete(C.getKey()));
		assertFalse(map.contains(C.getKey()));
		assertEquals(1, map.size());
		
		assertEquals(D.getValue(), map.delete(D.getKey()));
		assertFalse(map.contains(D.getKey()));
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
	}
	
	public void testDeleteNonExisting(){
		assertEquals(4, map.size());
		
		assertNull(map.delete(E.getKey()));
		assertEquals(4, map.size());
		
		assertNull(map.delete(F.getKey()));
		assertEquals(4, map.size());
	}
	
	public void testClear(){
		assertEquals(4, map.size());
		
		map.clear();
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		
		assertFalse(map.contains(A.getKey()));
		assertFalse(map.contains(B.getKey()));
		assertFalse(map.contains(C.getKey()));
		assertFalse(map.contains(D.getKey()));
	}
	
	public void testIteratorForwards() {
		checkIterator(map.iterator());
	}
	
	public void testIteratorBackwards() {
		checkIterator(new ReverseIterator<>(map.iterator()));
	}

	private void checkIterator(Iterator<Map.Entry<String, String>> i) {
		// TODO Auto-generated method stub
		List<Map.Entry<String, String>> entries = new LinkedList<>();
		
		for(i.first(); !i.isDone(); i.next()){
			entries.add(new DefaultEntry<>(i.current().getKey(), i.current().getValue()));
		}
		
		try {
			i.current();
			fail();
		} catch (IteratorOutOfBoundsException e) {
			// expected
		}
		
		assertEquals(4, entries.size());
		assertTrue(entries.contains(A));
		assertTrue(entries.contains(B));
		assertTrue(entries.contains(C));
		assertTrue(entries.contains(D));
		
	}
		
	
	
	

}
