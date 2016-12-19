package com.wrox.algorithms.hashing;

public class BucketingHashtableTest extends AbstractHashtableTestCase{

	@Override
	protected Hashtable<String> createHashtable(int capacity) {
		// TODO Auto-generated method stub
		return new BucketingHashtable<String>(capacity, 0.75f);
	}

}
