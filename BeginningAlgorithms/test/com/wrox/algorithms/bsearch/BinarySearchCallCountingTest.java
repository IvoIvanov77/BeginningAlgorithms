package com.wrox.algorithms.bsearch;

import java.util.Random;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.CallCountingComparator;
import com.wrox.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public class BinarySearchCallCountingTest extends TestCase{
	
	private static final int TEST_SIZE = 1021;
	private List<Integer> sortedList;
	private CallCountingComparator<Integer> comparator;
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.sortedList = new ArrayList<>(TEST_SIZE);
		for (int i = 0; i < TEST_SIZE; i++) {
			sortedList.add(new Integer(i));
		}
		this.comparator = new CallCountingComparator<Integer>(new NaturalComparator<>());
	}
	
	private void reportCalls(){
		System.out.println(this.getName() + ": " + this.comparator.getCallCount() + " cals");
	}
	
	public void testRecursiveBinarySearch() {
		performInOrderSearch(new RecursiveBinaryListSearcher<>(comparator));
	}
	
	public void testIterativeBinarySearch() {
		performInOrderSearch(new IterativeBinaryListSearcher<>(comparator));
	}
	
	public void testLinearSearch() {
		performInOrderSearch(new LinearListSearcher<>(comparator));
	}

	private void performInOrderSearch(ListSearcher<Integer> listSearcher) {
		// TODO Auto-generated method stub
		for (int i = 0; i < TEST_SIZE; i++) {
			listSearcher.search(sortedList, i);
		}
		reportCalls();
	}
	
	public void testRandomRecursiveBinarySearch() {
		performRandomSearch(new RecursiveBinaryListSearcher<>(comparator));
	}
	
	public void testRandomIterativeBinarySearch() {
		performRandomSearch(new IterativeBinaryListSearcher<>(comparator));
	}
	
	public void testRandomLinearSearch() {
		performRandomSearch(new LinearListSearcher<>(comparator));
	}

	private void performRandomSearch(ListSearcher<Integer> listSearcher) {
		// TODO Auto-generated method stub
		Random r = new Random();
		for (int i = 0; i < TEST_SIZE; i++) {
			listSearcher.search(sortedList, r.nextInt(TEST_SIZE));
		}
		reportCalls();
	}

}
