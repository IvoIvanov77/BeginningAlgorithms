package com.wrox.algorithms.queues;

import java.util.Comparator;

public class HeapOrderedListPriorityQueueTest extends AbstractPriorityQueueTestCase{

	@Override
	protected Queue<String> createQueue(Comparator<String> comparator) {
		// TODO Auto-generated method stub
		return new HeapOrderedListPriorityQueue<>(comparator);
	}

}
