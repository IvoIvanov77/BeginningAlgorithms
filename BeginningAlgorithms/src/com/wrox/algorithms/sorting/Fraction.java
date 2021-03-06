package com.wrox.algorithms.sorting;

public class Fraction {
	
	private final int numerator;
	private final int denominator;
	
	public Fraction(int numerator, int denominator) {		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return "[" + numerator + ", " + denominator + "]";
	}
	
	

	
	

}
