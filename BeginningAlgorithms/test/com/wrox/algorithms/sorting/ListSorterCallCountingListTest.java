package com.wrox.algorithms.sorting;

import java.util.Random;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.CallCountingList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public class ListSorterCallCountingListTest extends TestCase {
	
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
		CallCountingList<Integer> result = new CallCountingList<>(reverseArrayList);
		new BubblesortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testWorstCaseInsertionSort(){
		CallCountingList<Integer> result = new CallCountingList<>(reverseArrayList);
		new InsertionSortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testWorstCaseSelectionSort(){
		CallCountingList<Integer> result = new CallCountingList<>(reverseArrayList);
		new SelectionSortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testBestCaseBubbleSort(){
		CallCountingList<Integer> result = new CallCountingList<>(sortedArrayList);
		new BubblesortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testBestCaseInsertionSort(){
		CallCountingList<Integer> result = new CallCountingList<>(sortedArrayList);
		new InsertionSortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testBestCaseSelectionSort(){
		CallCountingList<Integer> result = new CallCountingList<>(sortedArrayList);
		new SelectionSortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testAverageCaseBubbleSort(){
		CallCountingList<Integer> result = new CallCountingList<>(randomArrayList);
		new BubblesortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testAverageCaseInsertionSort(){
		CallCountingList<Integer> result = new CallCountingList<>(randomArrayList);
		new InsertionSortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	public void testAverageCaseSelectionSort(){
		CallCountingList<Integer> result = new CallCountingList<>(randomArrayList);
		new SelectionSortListSorter<>(this.comparator).sort(result);
		reportCalls(result);
	}
	
	
	
	private void reportCalls(List<Integer> list) {
		System.out.println(getName() + ": " + list + " calls");
	}
	
	

}
