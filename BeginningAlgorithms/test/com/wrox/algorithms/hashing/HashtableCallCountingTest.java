package com.wrox.algorithms.hashing;

import java.util.Random;

import junit.framework.TestCase;

public class HashtableCallCountingTest extends TestCase {

	private static final int TEST_SIZE = 1000;
	private static final int INITIAL_CAPACITY = 17;
	private int counter;
	private Hashtable<Value> hashtable;

	public void testLinearProbingWithResizing() {
		this.hashtable = new LinearProbingHashtable<>(INITIAL_CAPACITY);
		runAll();
	}

	public void testLinearProbingNoResizing() {
		this.hashtable = new LinearProbingHashtable<>(TEST_SIZE);
		runAll();
	}

	public void testBucketsLoadFactor100Percent() {
		this.hashtable = new BucketingHashtable<>(INITIAL_CAPACITY, 1.0f);
		runAll();
	}

	public void testBucketsLoadFactor75Percent() {
		hashtable = new BucketingHashtable<>(INITIAL_CAPACITY, 0.75f);
		runAll();
	}

	public void testBuckets50Percent() {
		hashtable = new BucketingHashtable<>(INITIAL_CAPACITY, 0.50f);
		runAll();
	}

	public void testBuckets25Percent() {
		hashtable = new BucketingHashtable<>(INITIAL_CAPACITY, 0.25f);
		runAll();
	}

	public void testBuckets150Percent() {
		hashtable = new BucketingHashtable<>(INITIAL_CAPACITY, 1.50f);
		runAll();
	}

	public void testBuckets200Percent() {
		hashtable = new BucketingHashtable<>(INITIAL_CAPACITY, 2.0f);
		runAll();
	}

	private void runAll() {
		// TODO Auto-generated method stub
		runAdd();
		runContains();

	}

	private void runContains() {
		// TODO Auto-generated method stub
		this.counter = 0;
		for (int i = 0; i < TEST_SIZE; i++) {
			this.hashtable.contains(new Value());
		}
		reportCalls("contains");
	}

	private void runAdd() {
		// TODO Auto-generated method stub
		this.counter = 0;
		for (int i = 0; i < TEST_SIZE; i++) {
			this.hashtable.add(new Value());
		}
		reportCalls("add");
	}

	private void reportCalls(String method) {
		// TODO Auto-generated method stub
		System.out.println(getName() + "(" + method + "): " + this.counter + " calls.");

	}

	public final class Value {

		private String value;
		private Random r = new Random();

		public Value() {
			this.value = String.valueOf(r.nextInt(TEST_SIZE));
		}

		@Override
		public int hashCode() {
			return this.value.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			++counter;
			return obj != null && this.value.equals(((Value) obj).value);
		}

	}

}
