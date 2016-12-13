package com.wrox.algorithms.bsearch;

import java.util.Random;

import com.wrox.algorithms.lists.*;
import com.wrox.algorithms.sorting.*;

import junit.framework.TestCase;

public class BinaryInsertCallCountingTest extends TestCase {
	
	private static final int TEST_SIZE = 4091;
	private List<Integer> list;
	private CallCountingComparator<Integer> comparator;
	@Override
	
	
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.list = new ArrayList<>(TEST_SIZE);
		this.comparator = new CallCountingComparator<>(new NaturalComparator<Integer>());
		populateList();
	}
	
	private void populateList(){
		ListInserter<Integer> inserter = new ListInserter<>(
				new IterativeBinaryListSearcher<>(comparator));
		Random r = new Random();
		for (int i = 0; i < TEST_SIZE; i++) {
			inserter.insert(this.list, r.nextInt(TEST_SIZE));
		}
	}
	
	public void testBinaryInsert() {		
		reportCalls();
	}
	
	public void testMergeSort() {
		sortList(new MergesortListSorter<>(this.comparator));
	}
	
	public void testShellsort() {
		sortList(new ShellsortListSorter<>(this.comparator));
	}
	
	public void testQuicksort() {
		sortList(new QuicksortListSorter<>(this.comparator));
	}
	
	private void sortList(ListSorter<Integer> sorter) {
		sorter.sort(this.list);
		reportCalls();
	}

	private void reportCalls(){
		System.out.println(this.getName() + ": " + this.comparator.getCallCount() + " calls");
	}

}
