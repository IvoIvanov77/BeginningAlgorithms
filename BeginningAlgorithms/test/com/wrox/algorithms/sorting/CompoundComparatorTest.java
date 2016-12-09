package com.wrox.algorithms.sorting;

import junit.framework.TestCase;

public class CompoundComparatorTest extends TestCase{
	
	public void testComparisonContinuesWhileEqual() {
		CompoundComparator<String> comparator = new CompoundComparator<>();
		comparator.addComparator(new FixedComparator<String>(0));
		comparator.addComparator(new FixedComparator<String>(0));
		comparator.addComparator(new FixedComparator<String>(0));
		
		assertTrue(comparator.compare("IGNORED", "IGNORED") == 0);
	}
	
	public void testComparisonStopsWhenLessThan(){
		
		CompoundComparator<String> comparator = new CompoundComparator<>();
		comparator.addComparator(new FixedComparator<String>(0));
		comparator.addComparator(new FixedComparator<String>(0));
		comparator.addComparator(new FixedComparator<String>(-97));
		comparator.addComparator(new FixedComparator<String>(55));
		
		assertTrue(comparator.compare("IGNORED", "IGNORED") < 0);
		
	}
	
	public void testComparisonStopsWhenGreaterThan() {
		
		CompoundComparator<String> comparator = new CompoundComparator<>();
		comparator.addComparator(new FixedComparator<String>(0));
		comparator.addComparator(new FixedComparator<String>(0));
		comparator.addComparator(new FixedComparator<String>(97));
		comparator.addComparator(new FixedComparator<String>(- 55));
		
		assertTrue(comparator.compare("IGNORED", "IGNORED") > 0);
		
	}

}
