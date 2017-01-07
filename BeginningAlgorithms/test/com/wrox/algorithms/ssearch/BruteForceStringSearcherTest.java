package com.wrox.algorithms.ssearch;

public class BruteForceStringSearcherTest extends AbstractStringSearcher {

	@Override
	protected StringSearcher createSearcher(CharSequence pattern) {
		// TODO Auto-generated method stub
		return new BruteForceStringSearcher(pattern);
	}

}
