package com.wrox.algorithms.bsearch;

import java.util.Comparator;

public class LinearListSearcherTest extends AbstractListSearcherTestCase {

	@Override
	protected ListSearcher<String> createSearcher(Comparator<String> comparator) {
		// TODO Auto-generated method stub
		return new LinearListSearcher<>(comparator);
	}

}
