package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class InsertionSortListSorterTest extends AbstractListSorterTest {

	@Override
	protected ListSorter<String> createListSorter(Comparator<String> comparator) {
		// TODO Auto-generated method stub
		return new  InsertionSortListSorter<String>(comparator);
	}

}
