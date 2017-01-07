package com.wrox.algorithms.ssearch;

public class BruteForceStringSearcher implements StringSearcher {
	
	private final CharSequence pattern;

	public BruteForceStringSearcher(CharSequence pattern) {
		// TODO Auto-generated constructor stub
		assert pattern != null : "pattern can’t be null";
		assert pattern.length() > 0 : "pattern can’t be empty";
		this.pattern = pattern;
	}

	@Override
	public StringMatch search(CharSequence text, int from) {
		// TODO Auto-generated method stub		
		assert text != null : "text can’t be null";
		assert from >= 0 : "from can’t be < 0";
		
		int s = from;
		while (s <= text.length() - pattern.length()) {
			int i = 0;
		
			while (i < pattern.length()&& pattern.charAt(i) == text.charAt(s + i)) {
				i ++;
			}
			
			if (i == pattern.length()) {
				return new StringMatch(pattern, text, s);
			}else{
				s ++;
			}
			
		}
		return null;
	}

}
