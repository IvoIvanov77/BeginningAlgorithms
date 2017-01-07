package com.wrox.algorithms.ssearch;

public class BoyerMooreStringSearcher implements StringSearcher {
	
	private final CharSequence pattern;
	private final short[] lastOccurrence;

	public BoyerMooreStringSearcher(CharSequence pattern) {
		// TODO Auto-generated constructor stub
		assert pattern != null : "pattern can’t be null";
		assert pattern.length() > 0 : "pattern can’t be empty";
		this.pattern = pattern;
		this.lastOccurrence = computeLastOccurrence(pattern);
	}	

	@Override
	public StringMatch search(CharSequence text, int from) {
		// TODO Auto-generated method stub
		assert text != null : "text can’t be null";
		assert from >= 0 : "from can’t be < 0";
		
		int s = from;
		
		while(s <= text.length() - pattern.length()){
			int i = pattern.length() - 1;
			char ch = 0;
			while(i >= 0 && pattern.charAt(i) == (ch = text.charAt(s + i))){
				i --;
			}
			if(i < 0){
				return new StringMatch(pattern, text, s);
			}
			s += Math.max(i - lastOccurrence[ch], 1);
		}
		
		return null;
	}
	
	private short[] computeLastOccurrence(CharSequence pattern2) {
		// TODO Auto-generated method stub
		short[] lastOccurrence = new short[256];
		for (int i = 0; i < lastOccurrence.length; i++) {
			lastOccurrence[i] = -1;
		}
		for (int i = 0; i < pattern.length(); i++) {
			int index = pattern.charAt(i);
			lastOccurrence[index] = (short) i;
		}
		return lastOccurrence;
	}

}
