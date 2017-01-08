package com.wrox.algorithms.wmatch;

import junit.framework.TestCase;

public class SoundexPhoneticEncoderTest extends TestCase{
	
	private SoundexPhoneticEncoder encoder;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.encoder = SoundexPhoneticEncoder.INSTANCE;
	}
	
	public void testFirstLetterIsAlwaysUsed(){
		for(char ch = 'A'; ch <='Z'; ch ++){
			String result = encoder.encode(ch + "-");
			assertNotNull(result);
			assertEquals(4, result.length());
			assertEquals(ch, result.charAt(0));
		}		
	}
	
	public void testVowelsAreIgnored() {
		assertAllEquals('0', new char[] {'A', 'E', 'I', 'O', 'U', 'H', 'W', 'Y'});
	}
	
	public void testLettersRepresentedByOne() {
		assertAllEquals('1', new char[] {'B', 'F', 'P', 'V'});
	}
	
	public void testLettersRepresentedByTwo() {
		assertAllEquals('2', new char[] {'C', 'G', 'J', 'K', 'Q', 'S', 'X', 'Z'});
	}
	
	public void testLettersRepresentedByThree() {
		assertAllEquals('3', new char[] {'D', 'T'});
	}
	
	public void testLettersRepresentedByFour() {
		assertAllEquals('4', new char[] {'L'});
	}
	
	public void testLettersRepresentedByFive() {
		assertAllEquals('5', new char[] {'M', 'N'});
	}
	
	public void testLettersRepresentedBySix() {
		assertAllEquals('6', new char[] {'R'});
	}
	
	public void testDuplicateCodesAreDropped() {
		assertEquals("B100", encoder.encode("BFPV"));
		assertEquals("C200", encoder.encode("CGJKQSXZ"));
		assertEquals("D300", encoder.encode("DDT"));
		assertEquals("L400", encoder.encode("LLL"));
		assertEquals("M500", encoder.encode("MNMN"));
		assertEquals("R600", encoder.encode("RRR"));
	}
	
	public void testSomeRealStrings() {
		assertEquals("S530", encoder.encode("Smith"));
		assertEquals("S530", encoder.encode("Smythe"));
		assertEquals("M235", encoder.encode("McDonald"));
		assertEquals("M235", encoder.encode("MacDonald"));
		assertEquals("H620", encoder.encode("Harris"));
		assertEquals("H620", encoder.encode("Harrys"));
	}

	private void assertAllEquals(char expectedValue, char[] chars) {
		// TODO Auto-generated method stub
		for (int i = 0; i < chars.length; i++) {
			String result = encoder.encode("-" + chars[i]);
			assertNotNull(result);
			assertEquals(4, result.length());
			assertEquals("-" + expectedValue + "00" , result);
		}		
	}
	
	

}
