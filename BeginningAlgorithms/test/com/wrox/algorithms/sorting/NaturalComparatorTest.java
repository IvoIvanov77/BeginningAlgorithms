package com.wrox.algorithms.sorting;

import junit.framework.TestCase;

public class NaturalComparatorTest extends TestCase {

	public void testLessThan() {
		assertTrue(new NaturalComparator<String>().compare("A", "B") < 0);
	}
	
	public void testGreaterThan() {
		assertTrue(new NaturalComparator<String>().compare("B", "A") > 0);
	}
	
	public void testEqualsTo() {
		assertTrue(new NaturalComparator<String>().compare("A", "A") == 0);
	}

}
