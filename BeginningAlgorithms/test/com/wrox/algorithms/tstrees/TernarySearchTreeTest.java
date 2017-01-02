package com.wrox.algorithms.tstrees;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public class TernarySearchTreeTest extends TestCase {
	
	private TernarySearchTree tree;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		this.tree = new TernarySearchTree();
		
		tree.add("prefabricate");
        tree.add("presume");
        tree.add("prejudice");
        tree.add("preliminary");
        tree.add("apple");
        tree.add("ape");
        tree.add("appeal");
        tree.add("car");
        tree.add("dog");
        tree.add("cat");
        tree.add("mouse");
        tree.add("mince");
        tree.add("minty");

	}
	
	public void testContains(){
		assertTrue(tree.contains("prefabricate"));
        assertTrue(tree.contains("presume"));
        assertTrue(tree.contains("prejudice"));
        assertTrue(tree.contains("preliminary"));
        assertTrue(tree.contains("apple"));
        assertTrue(tree.contains("ape"));
        assertTrue(tree.contains("appeal"));
        assertTrue(tree.contains("car"));
        assertTrue(tree.contains("dog"));
        assertTrue(tree.contains("cat"));
        assertTrue(tree.contains("mouse"));
        assertTrue(tree.contains("mince"));
        assertTrue(tree.contains("minty"));

        assertFalse(tree.contains("pre"));
        assertFalse(tree.contains("dogs"));
        assertFalse(tree.contains("UNKNOWN"));
	}
	
	public void testPrefixSearch(){
		assertPrefixEquals(new String[] {"prefabricate", "prejudice", "preliminary", 
				"presume"}, "pre");
        assertPrefixEquals(new String[] {"ape", "appeal", "apple"}, "ap");
	}
	
	public void testPatternMatch(){
		assertPatternEquals(new String[] {"mince", "mouse"}, "m???e");
        assertPatternEquals(new String[] {"car", "cat"}, "?a?");
	}	

	private void assertPrefixEquals(String[] expected, String prefix) {
		// TODO Auto-generated method stub
		List<String> words = new LinkedList<>();
		tree.prefixSearch(prefix, words);
		assertEquals(expected, words);
		
	}
	
	private void assertPatternEquals(String[] expected, String pattern) {
		// TODO Auto-generated method stub
		List<String> words = new LinkedList<>();
		tree.patternMatch(pattern, words);
		assertEquals(expected, words);
	}
	
	private void assertEquals(String[] expected, List<String> actual){
		assertEquals(expected.length, actual.size());
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual.get(i));			
		}
	}
	

}
