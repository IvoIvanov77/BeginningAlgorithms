package com.wrox.algorithms.hashing;

import junit.framework.TestCase;

public abstract class AbstractHashtableTestCase extends TestCase {
	
	private static final int TEST_SIZE = 1000;
	private Hashtable<String> hashatble;
	
	protected abstract Hashtable<String> createHashtable(int capacity);

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.hashatble = createHashtable(TEST_SIZE);
		
		for (int i = 0; i < TEST_SIZE; i++) {
			this.hashatble.add(String.valueOf(i));
		}
	}
	
	public void testContains(){
		for (int i = 0; i < TEST_SIZE; i++) {
			assertTrue(this.hashatble.contains(String.valueOf(i)));
		}
	}
	
	public void testDoesNotContains(){
		for (int i = 0; i < TEST_SIZE; i++) {
			assertFalse(this.hashatble.contains(String.valueOf(i + TEST_SIZE)));
		}
	}
	
	public void testAddingTheSameValuesDoesntChangeTheSize() {
		assertEquals(TEST_SIZE, this.hashatble.size());
		
		for (int i = 0; i < TEST_SIZE; i++) {
			this.hashatble.add(String.valueOf(i));
			assertEquals(TEST_SIZE, this.hashatble.size());
		}
	}
	
	
	
	
}
