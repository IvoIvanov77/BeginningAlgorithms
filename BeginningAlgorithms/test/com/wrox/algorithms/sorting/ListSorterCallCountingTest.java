package com.wrox.algorithms.sorting;

import java.util.Random;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public class ListSorterCallCountingTest extends TestCase {
	
	private final static int TEST_SIZE = 1000;
	
	private final List<Integer> sortedArrayList = new ArrayList<>();
	private final List<Integer> reverseArrayList = new ArrayList<>();
	private final List<Integer> randomArrayList = new ArrayList<>();
	
	private CallCountingComparator<Integer> comparator;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		this.comparator = new CallCountingComparator<Integer>(new NaturalComparator<>());
		
		for (int i = 1; i <= TEST_SIZE; i++) {
			this.sortedArrayList.add(i);
			this.reverseArrayList.add(TEST_SIZE - i + 1);
			this.randomArrayList.add(new Random().nextInt(TEST_SIZE) + 1);
		}
	}
	
	public void testWorstCaseBubbleSort(){
		new BubblesortListSorter<>(this.comparator).sort(reverseArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testWorstCaseInsertionSort(){
		new InsertionSortListSorter<>(this.comparator).sort(reverseArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testWorstCaseSelectionSort(){
		new SelectionSortListSorter<>(this.comparator).sort(reverseArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testBestCaseBubbleSort(){
		new BubblesortListSorter<>(this.comparator).sort(sortedArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testBestCaseInsertionSort(){
		new InsertionSortListSorter<>(this.comparator).sort(sortedArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testBestCaseSelectionSort(){
		new SelectionSortListSorter<>(this.comparator).sort(sortedArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testAverageCaseBubbleSort(){
		new BubblesortListSorter<>(this.comparator).sort(randomArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testAverageCaseInsertionSort(){
		new InsertionSortListSorter<>(this.comparator).sort(randomArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	public void testAverageCaseSelectionSort(){
		new SelectionSortListSorter<>(this.comparator).sort(randomArrayList);
		reportCalls(this.comparator.getCallCount());
	}
	
	
	
	private void reportCalls(int callCount) {
		System.out.println(getName() + ": " + callCount + " calls");
	}
	
	

}
