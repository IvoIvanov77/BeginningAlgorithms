package com.wrox.algorithms.bstrees;

import java.util.Random;

import com.wrox.algorithms.lists.*;
import com.wrox.algorithms.sorting.CallCountingComparator;
import com.wrox.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public class BinarySearchTreeCallCountingTest extends TestCase{
	
	private static final int TEST_SIZE = 1000;
	private CallCountingComparator<Integer> comparator;
	private BinarySearchTree<Integer> tree;
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.comparator = new CallCountingComparator<>(new NaturalComparator<Integer>());
		this.tree = new BinarySearchTree<>(comparator);
	}
	
	public void testRandomInsertion() {
		Random r = new Random();
		for (int i = 0; i < TEST_SIZE; i++) {
			this.tree.insert(r.nextInt(TEST_SIZE));
		}
		reportCalls();
	}

	private void reportCalls() {
		// TODO Auto-generated method stub
		System.out.println(getName() +" call " + comparator.getCallCount());
		
	}
	
	public void testInOrderInsertion() {
		for (int i = 0; i < TEST_SIZE; i++) {
			this.tree.insert(new Integer(i));
		}
		reportCalls();
	}
	
	public void testPreOrderInsertion() {
		List<Integer> list = new ArrayList<>(TEST_SIZE);
		for (int i = 0; i < TEST_SIZE; ++i) {
			list.add(new Integer(i));
		}
		preOrderInsert(list, 0, list.size() - 1);
		reportCalls();
	}
	
	public void testinsertFromSotrtedList() {
		List<Integer> list = new ArrayList<>(TEST_SIZE);
		for (int i = 0; i < TEST_SIZE; ++i) {
			list.add(new Integer(i));
		}
		this.tree.insertFromSotrtedList(list);
		reportCalls();		
	}
	
	private void preOrderInsert(List<Integer> list, int lowerIndex, int upperIndex) {
		if (lowerIndex > upperIndex) {
			return;
		}
		int index = lowerIndex + (upperIndex - lowerIndex) / 2;
		this.tree.insert(list.get(index));
		preOrderInsert(list, lowerIndex, index - 1);
		preOrderInsert(list, index + 1, upperIndex);
	}

}
