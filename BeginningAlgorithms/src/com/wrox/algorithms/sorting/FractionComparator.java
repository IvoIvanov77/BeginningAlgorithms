package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class FractionComparator implements Comparator<Fraction> {

	@Override
	public int compare(Fraction f1, Fraction f2) {
		// TODO Auto-generated method stub
		return f1.getNumerator() - f2.getNumerator();
	}

	
}
