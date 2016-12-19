package com.wrox.algorithms.hashing;

public class LinearProbingHashtableTest extends AbstractHashtableTestCase {

	@Override
	protected Hashtable<String> createHashtable(int capacity) {
		// TODO Auto-generated method stub
		return new LinearProbingHashtable<String>(capacity);
	}

}
