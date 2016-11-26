package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public abstract class AbstractListSorterTest extends TestCase{
	
	private List<String> unsortedList;
	private List<String> sortedList;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		this.unsortedList = new LinkedList<>();
		
		unsortedList.add("test");
		unsortedList.add("driven");
		unsortedList.add("development");
		unsortedList.add("is");
		unsortedList.add("one");
		unsortedList.add("small");
		unsortedList.add("step");
		unsortedList.add("for");
		unsortedList.add("a");
		unsortedList.add("programmer");
		unsortedList.add("but");
		unsortedList.add("it’s");
		unsortedList.add("one");
		unsortedList.add("giant");
		unsortedList.add("leap");
		unsortedList.add("for");
		unsortedList.add("programming");
		
		this.sortedList = new LinkedList<>();
		
		sortedList.add("a");
		sortedList.add("but");
		sortedList.add("development");
		sortedList.add("driven");
		sortedList.add("for");
		sortedList.add("for");
		sortedList.add("giant");
		sortedList.add("is");
		sortedList.add("it’s");
		sortedList.add("leap");
		sortedList.add("one");
		sortedList.add("one");
		sortedList.add("programmer");
		sortedList.add("programming");
		sortedList.add("small");
		sortedList.add("step");
		sortedList.add("test");

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		this.unsortedList = null;
		this.sortedList = null; 
	}
	
	protected abstract ListSorter<String> createListSorter(Comparator<String> comparator);
	
	public void testListSorterCanSortSampleList(){
		
		ListSorter<String> sorter = createListSorter(new NaturalComparator<>());
		
		List<String> result = sorter.sort(unsortedList);
		
		assertEquals(result.size(), this.sortedList.size());
		
		Iterator<String> actual = result.iterator();
		actual.first();
		
		Iterator<String> expected = this.sortedList.iterator();
		expected.first();
		
		while (!expected.isDone()) {
			assertEquals(expected.current(), actual.current());
			
			actual.next();
			expected.next();			
		}		
	}	
}
