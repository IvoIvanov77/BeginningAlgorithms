package com.wrox.algorithms.ssearch;

public class BoyerMooreStringSearcherTest extends AbstractStringSearcher{

	@Override
	protected StringSearcher createSearcher(CharSequence pattern) {
		// TODO Auto-generated method stub
		return new BoyerMooreStringSearcher(pattern);
	}
	
	public void testShiftsDontErroneouslyIgnoreMatches(){
		String text = "aababaa";
		String pattern = "baba";
		
		this.searcher = createSearcher(pattern);
		
		StringMatch match = searcher.search(text, 0);
		assertNotNull(match);
		assertEquals(text, match.getText());
		assertEquals(pattern, match.getPattern());
		assertEquals(2, match.getIndex());
		
		assertNull(searcher.search(text, match.getIndex() + 1));
	}

}
