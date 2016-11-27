package com.wrox.algorithms.sorting;

import java.util.Random;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public class ListSorterRandomDoublesTest extends TestCase {
	
	private final static int TEST_SIZE = 1000;	
	private final List<Double> randomArrayList = new ArrayList<>(TEST_SIZE);	
	private final NaturalComparator<Double> comparator = new NaturalComparator<>();

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub	
		
		for (int i = 1; i <= TEST_SIZE; i++) {			
			this.randomArrayList.add(new Random().nextDouble() * TEST_SIZE);			
		}		
	}
	
	public void testsortingRandomDoublesWithBubblesort(){
		new BubblesortListSorter<>(this.comparator).sort(this.randomArrayList);
		assertSort(randomArrayList);		
	}
	
	public void testsortingRandomDoublesWithSelectionsort() {
		new InsertionSortListSorter<>(this.comparator).sort(this.randomArrayList);
		assertSort(randomArrayList);
	}
	
	public void testsortingRandomDoublesWithInsertionsort(){
		new SelectionSortListSorter<>(this.comparator).sort(this.randomArrayList);
		assertSort(randomArrayList);
	}
	
	
	private void assertSort(List<Double> list) {
		for(int i = 1; i < list.size(); i ++){
			double right = list.get(i);
			double left = list.get(i - 1);
			assertTrue(this.comparator.compare(left, right) <= 0);
		}
	}
	
	

}
