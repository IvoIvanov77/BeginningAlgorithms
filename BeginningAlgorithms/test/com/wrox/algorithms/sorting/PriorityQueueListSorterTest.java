package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class PriorityQueueListSorterTest extends AbstractListSorterTest{

	@Override
	protected ListSorter<String> createListSorter(Comparator<String> comparator) {
		// TODO Auto-generated method stub
		return new PriorityQueueListSorter<>(comparator);
	}

}
