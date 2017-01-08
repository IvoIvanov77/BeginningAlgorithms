package com.wrox.algorithms.wmatch;

public class SoundexPhoneticEncoder implements PhoneticEncoder {

	public static final SoundexPhoneticEncoder INSTANCE = new SoundexPhoneticEncoder();
	
	private static final char[] CHARACTER_MAP =
			"01230120022455012623010202".toCharArray();
	
	private SoundexPhoneticEncoder(){
		
	}

	@Override
	public String encode(CharSequence string) {
		// TODO Auto-generated method stub
		assert string != null : "string can’t be null";
		assert string.length() > 0 : "string can’t be empty";
		
		char[] result = {'0', '0', '0', '0'};
		result[0] = Character.toUpperCase(string.charAt(0));
		
		int stringIndex = 1;
		int resultIndex = 1;
		
		while(stringIndex < string.length() && resultIndex < result.length){
			char ch = map(string.charAt(stringIndex));
			if(ch != '0' && ch != result[resultIndex - 1]){
				result[resultIndex] = ch;
				resultIndex ++;
			}
			stringIndex ++;
		}
		return String.valueOf(result);
	}

	private char map(char ch) {
		// TODO Auto-generated method stub
		int index = Character.toUpperCase(ch) - 'A';
		return isValid(index) ? CHARACTER_MAP[index] : '0';
	}

	private boolean isValid(int index) {
		// TODO Auto-generated method stub
		return index >= 0 && index < CHARACTER_MAP.length;
	}

}
