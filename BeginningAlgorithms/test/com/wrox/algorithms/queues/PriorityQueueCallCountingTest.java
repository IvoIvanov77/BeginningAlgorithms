package com.wrox.algorithms.queues;

import java.util.Random;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.CallCountingComparator;
import com.wrox.algorithms.sorting.NaturalComparator;
import junit.framework.TestCase;

public class PriorityQueueCallCountingTest extends TestCase {

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

	public void testWorstCaseUnsortedList() {
		runScenario(new UnsortedListPriorityQueue<>(this.comparator), this.reverseArrayList);
	}

	public void testWorstCaseSortedList() {
		runScenario(new SortedListPriorityQueue<>(this.comparator), this.reverseArrayList);
	}

	public void testWorstCaseHeapOrderedList() {
		runScenario(new HeapOrderedListPriorityQueue<>(this.comparator), this.reverseArrayList);
	}

	public void testBestCaseUnsortedList() {
		runScenario(new UnsortedListPriorityQueue<>(this.comparator), this.sortedArrayList);
	}

	public void testBestCaseSortedList() {
		runScenario(new SortedListPriorityQueue<>(this.comparator), this.sortedArrayList);
	}

	public void testBestCaseHeapOrderedList() {
		runScenario(new HeapOrderedListPriorityQueue<>(this.comparator), this.sortedArrayList);
	}

	public void testAverageCaseUnsortedList() {
		runScenario(new UnsortedListPriorityQueue<>(this.comparator), this.randomArrayList);
	}

	public void testAverageCaseSortedList() {
		runScenario(new SortedListPriorityQueue<>(this.comparator), this.randomArrayList);
	}

	public void testAverageCaseHeapOrderedList() {
		runScenario(new HeapOrderedListPriorityQueue<>(this.comparator), this.randomArrayList);
	}

	private void runScenario(Queue<Integer> queue, List<Integer> input) {
		// TODO Auto-generated method stub
		int i = 0;
		Iterator<Integer> iterator = input.iterator();
		iterator.first();
		while (!iterator.isDone()) {
			i ++;
			queue.enqueue(iterator.current());
			if (i % 100 == 0) {
				for (int j = 0; j < 25; j ++) {
					queue.dequeue();
				}
			}
			iterator.next();
		}
		while (!queue.isEmpty()) {
			queue.dequeue();
		}
		reportCalls();

	}

	private void reportCalls() {
		int callCount = this.comparator.getCallCount();
		System.out.println(getName() + ": " + callCount + " calls");
	}

}
