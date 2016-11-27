package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		Comparator<String> c = new CaseInsensitiveStringComparator();
		
		System.out.println(c.compare("IVO", "ivo") == 0);
	}

}
