package com.wrox.algorithms.maps;

import com.wrox.algorithms.sets.AbstractSetTestCase;
import com.wrox.algorithms.sets.Set;

public class HashMapSetTest extends AbstractSetTestCase {

	@Override
	protected Set<String> createSet() {
		// TODO Auto-generated method stub
		return new MapSet<>(new HashMap<>());
	}

}
