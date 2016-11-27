package com.wrox.algorithms.sorting;

import java.util.Comparator;

public class CaseInsensitiveStringComparator implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
		// TODO Auto-generated method stub
		return str1.toLowerCase().compareTo(str2.toLowerCase());
	}

}
