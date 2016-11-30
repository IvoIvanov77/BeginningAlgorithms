package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class MyShellsortImplementationTest extends AbstractListSorterTest {

	@Override
	protected ListSorter<String> createListSorter(Comparator<String> comparator) {
		// TODO Auto-generated method stub
		return new MyShellSortImpementation<String>(comparator);
	}

}
