package com.wrox.algorithms.bsearch;

import java.util.Random;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public class ListInserterTest extends TestCase {
	
	private static final int TEST_SIZE = 1023;
	private ListInserter<Integer> inserter;
	private List<Integer> list;
	@Override
	
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.inserter = new ListInserter<>(new IterativeBinaryListSearcher<>(
				new NaturalComparator<Integer>()));
		this.list = new ArrayList<>(TEST_SIZE);
	}
	
	private void verify(){
		int previousValue = Integer.MIN_VALUE;
		Iterator<Integer> i = list.iterator();
		for(i.first(); !i.isDone(); i.next()){
			assertTrue(previousValue <= i.current());
			previousValue = i.current();
		}
	}
	
	public void testAscendingInOrderInsertion(){
		for (int i = 0; i < TEST_SIZE; i++) {
			assertEquals(i, this.inserter.insert(this.list, i));
		}
		verify();
	}
	
	public void testDescendingInOrderInsertion() {
		for(int i = TEST_SIZE - 1; i >= 0; i--){
			assertEquals(0, this.inserter.insert(this.list, i));
		}
		verify();
	}
	
	public void testRandomInsertion(){
		Random r = new Random();
		for (int i = 0; i < TEST_SIZE; i++) {
			this.inserter.insert(this.list, r.nextInt(TEST_SIZE));
		}
		verify();
	}

}
