package com.wrox.algorithms.sorting;

import junit.framework.TestCase;

public class ReverseComparatorTest extends TestCase {

	public void testLessThanBecomesGreaterThan() {
		assertTrue(new ReverseCompalator<String>(
				new NaturalComparator<String>()).compare("A", "B") > 0);
	}
	
	public void testGreaterThanBecomesLessThan() {
		assertTrue(new ReverseCompalator<String>(
				new NaturalComparator<String>()).compare("B", "A") < 0);
	}
	
	public void testEqualsTo() {
		assertTrue(new ReverseCompalator<String>(
				new NaturalComparator<String>()).compare("A", "A") == 0);
	}

}
