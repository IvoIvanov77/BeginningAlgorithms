package com.wrox.algorithms.queues;

import java.util.Comparator;

import com.wrox.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public abstract class AbstractPriorityQueueTestCase extends TestCase {

	private static final String VALUE_A = "A";
	private static final String VALUE_B = "B";
	private static final String VALUE_C = "C";
	private static final String VALUE_D = "D";
	private static final String VALUE_E = "E";

	private Queue<String> queue;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.queue = createQueue(new NaturalComparator<>());
	}

	protected abstract Queue<String> createQueue(Comparator<String> comparator);

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		this.queue = null;
		super.tearDown();
	}

	public void testAccessAnEmptyQueue() {
		assertEquals(0, this.queue.size());
		assertTrue(this.queue.isEmpty());

		try {
			this.queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {

		}
	}

	public void testEnqueueDequeue() {
		this.queue.enqueue(VALUE_B);
		this.queue.enqueue(VALUE_D);
		this.queue.enqueue(VALUE_A);

		assertEquals(3, this.queue.size());
		assertFalse(this.queue.isEmpty());

		assertSame(VALUE_D, this.queue.dequeue());
		assertEquals(2, this.queue.size());
		assertFalse(this.queue.isEmpty());

		assertSame(VALUE_B, this.queue.dequeue());
		assertEquals(1, this.queue.size());
		assertFalse(this.queue.isEmpty());
		
		this.queue.enqueue(VALUE_E);
		this.queue.enqueue(VALUE_C);
		
		assertEquals(3, this.queue.size());
		assertFalse(this.queue.isEmpty());
		
		assertSame(VALUE_E, this.queue.dequeue());
		assertEquals(2, this.queue.size());
		assertFalse(this.queue.isEmpty());

		assertSame(VALUE_C, this.queue.dequeue());
		assertEquals(1, this.queue.size());
		assertFalse(this.queue.isEmpty());

		assertSame(VALUE_A, this.queue.dequeue());
		assertEquals(0, this.queue.size());
		assertTrue(this.queue.isEmpty());

		try {
			this.queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {

		}
	}
	
	public void testClear(){
		this.queue.enqueue(VALUE_B);
		this.queue.enqueue(VALUE_A);
		this.queue.enqueue(VALUE_C);
		
		assertFalse(this.queue.isEmpty());
		
		this.queue.clear();
		
		assertEquals(0, this.queue.size());
		assertTrue(this.queue.isEmpty());
		
		try {
			this.queue.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			
		}
	}

}
