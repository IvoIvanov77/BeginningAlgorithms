package com.wrox.algorithms.ssearch;

public class StringMatch {
	
	private final CharSequence pattern;
	private final CharSequence text;
	private final int index;
	
	public StringMatch(CharSequence pattern, CharSequence text, int index) {
		assert text != null : "text can’t be null";
		assert pattern != null : "pattern can’t be null";
		assert index >= 0 : "index can’t be < 0";
		
		this.pattern = pattern;
		this.text = text;
		this.index = index;
	}

	public CharSequence getPattern() {
		return pattern;
	}

	public CharSequence getText() {
		return text;
	}

	public int getIndex() {
		return index;
	}
	
	

}
