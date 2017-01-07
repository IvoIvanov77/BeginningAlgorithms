package com.wrox.algorithms.ssearch;

public class CallCountingCharSequence implements CharSequence{
	
	private final CharSequence charSequence;
	private int callCount;
	
	

	public CallCountingCharSequence(CharSequence charSequence) {
		assert charSequence != null : "charSequence can’t be null";
		this.charSequence = charSequence;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		this.callCount ++;
		return this.charSequence.charAt(index);
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return this.charSequence.length();
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return this.charSequence.subSequence(start, end);
	}

	public int getCallCount() {
		return callCount;
	}	

}
