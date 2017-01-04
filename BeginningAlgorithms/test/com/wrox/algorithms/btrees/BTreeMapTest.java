package com.wrox.algorithms.btrees;

import com.wrox.algorithms.maps.AbstractMapTestCase;
import com.wrox.algorithms.maps.Map;
import com.wrox.algorithms.sorting.NaturalComparator;

public class BTreeMapTest extends AbstractMapTestCase{

	@Override
	protected Map<String, String> createMap() {
		// TODO Auto-generated method stub
		return new BTreeMap<String, String>(new NaturalComparator<>(), 2);
	}

}
