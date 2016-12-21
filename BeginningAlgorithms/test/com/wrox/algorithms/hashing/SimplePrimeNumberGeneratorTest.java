package com.wrox.algorithms.hashing;

import junit.framework.TestCase;

public class SimplePrimeNumberGeneratorTest extends TestCase{
	
	private SimplePrimeNumberGenerator generator = SimplePrimeNumberGenerator.INSTANCE;
	
	public void testGenerate(){
		assertEquals(11, generator.generate(10));
		assertEquals(17, generator.generate(14));
	}

}
