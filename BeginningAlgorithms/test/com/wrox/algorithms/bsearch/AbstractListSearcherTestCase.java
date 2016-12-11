package com.wrox.algorithms.bsearch;

import java.util.Comparator;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public abstract class AbstractListSearcherTestCase extends TestCase{
	
	private static final String[] VALUES = {"B", "C", "D", "F", "H", "I",
			"J", "K", "L", "M", "P", "Q"};
	
	private ListSearcher<String> searcher;
	private List<String> list;
	
	protected abstract ListSearcher<String> createSearcher(Comparator<String> comparator);

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.searcher = createSearcher(new NaturalComparator<>());
		this.list = new ArrayList<>(VALUES);
	}
	
	public void testSearchForExistingValues(){
		for (int i = 0; i < list.size(); i++) {
			assertEquals(i, searcher.search(list, list.get(i)));
		}
	}
	
	public void testSearchForNonExistingValueLessThanFirstItem(){
		assertEquals(-1, searcher.search(list, "A"));
	}
	
	public void testSearchForNonExistingValueGreaterThanLastItem(){
		assertEquals(-13, searcher.search(list, "Z"));
	}
	
	public void testSearchForArbitraryNonExistingValue(){
		assertEquals(-4, searcher.search(list, "E"));
	}
}
