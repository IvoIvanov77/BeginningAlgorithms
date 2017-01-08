package com.wrox.algorithms.wmatch;

import junit.framework.TestCase;

public class LevenshteinWordDistanceCalculatorTest extends TestCase {

	private LevenshteinWordDistanceCalculator calculator;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.calculator = LevenshteinWordDistanceCalculator.DEFAULT;
	}

	public void testEmptyToEmpty() {
		assertDistance(0, "", "");
	}

	public void testEmptyToNonEmpty() {
		String target = "any";
		assertDistance(target.length(), "", target);
	}

	public void testSamePrefix() {
		assertDistance(3, "unzip", "undo");
	}

	public void testSameSuffix() {
		assertDistance(4, "eating", "running");
	}
	
	public void testArbitrary(){
		assertDistance(3, "msteak", "mistake");
		assertDistance(3, "necassery", "neccessary");
		assertDistance(5, "donkey", "mule");
	}

	private void assertDistance(int distance, String source, String target) {
		// TODO Auto-generated method stub
		assertEquals(distance, calculator.calculate(source, target));
		assertEquals(distance, calculator.calculate(target, source));
	}

}
