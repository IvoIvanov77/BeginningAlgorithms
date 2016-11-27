package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public class ListSorterStabilityTest extends TestCase{
	
	private final static int TEST_SIZE = 1000;	
	private final List<Fraction> list = new ArrayList<>(TEST_SIZE);	
	private final FractionComparator comparator = new FractionComparator();
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		for (int i = 1; i <= TEST_SIZE; i++) {
			list.add(new Fraction(i % 20, i));
		}
	}
	
	public void testStabilityOfBubbleSort(){
		new BubblesortListSorter<>(comparator).sort(list);		
		assertStableSorted(list);
		
	}
	
	public void testStabilityOfInsertionSort(){
		new InsertionSortListSorter<>(comparator).sort(list);
		assertStableSorted(list);
	}
	
	public void testStabilityOfSelectionSort(){
		new SelectionSortListSorter<>(comparator).sort(list);
		assertStableSorted(list);
	}
	
	private void assertStableSorted(List<Fraction> list){
		for (int i = 1; i < list.size(); i++) {
			Fraction f1 = list.get(i - 1);
			Fraction f2 = list.get(i);
			if(comparator.compare(f1, f2) == 0){				
				assertTrue(f1.getDenominator() < f2.getDenominator() );
			}
		}
	}

}
