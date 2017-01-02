package com.wrox.algorithms.tstrees;

import com.wrox.algorithms.lists.List;


public class TernarySearchTree {
	
	private static final class Node {
		
		private final char c;
		private Node smaller;
		private Node larger;
		private Node child;
		private String word;

		public Node(char c) {
			// TODO Auto-generated constructor stub
			this.c = c;			
		}

		public Node getSmaller() {
			return smaller;
		}

		public void setSmaller(Node smaller) {
			this.smaller = smaller;
		}

		public Node getLarger() {
			return larger;
		}

		public void setLarger(Node larger) {
			this.larger = larger;
		}

		public Node getChild() {
			return child;
		}

		public void setChild(Node child) {
			this.child = child;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		public char getChar() {
			return c;
		}
		
		public boolean isEndOfWord(){
			return this.word != null;
		}

	}

	public static final char WILDCART = '?';
	private Node root;

	public void add(CharSequence word) {
		// TODO Auto-generated method stub
		assert word != null : "word can’t be null";
		assert word.length() > 0 : "word can’t be empty";
		Node node = insert(this.root, word, 0);
		
		if(this.root == null){
			this.root = node;
		}
	}
	

	public boolean contains(CharSequence word) {
		// TODO Auto-generated method stub
		assert word != null : "word can’t be null";
		assert word.length() > 0 : "word can’t be empty";
		Node node = iterativeSearch(this.root, word, 0);		
		return node != null && node.isEndOfWord();
	}


	public void prefixSearch(CharSequence prefix, List<String> words) {
		// TODO Auto-generated method stub
		assert prefix != null : "word can’t be null";
		assert prefix.length() > 0 : "word can’t be empty";
		
		inOrderTraversal(search(this.root, prefix, 0), words);
	}


	public void patternMatch(CharSequence pattern, List<String> words) {
		// TODO Auto-generated method stub
		assert pattern != null : "pattern can’t be null";
		assert pattern.length() > 0 : "pattern can’t be empty";
		assert words != null : "results can’t be null";
		patternMatch(this.root, pattern, 0, words);
		
	}

	private Node insert(Node node, CharSequence word, int index) {
		// TODO Auto-generated method stub
		assert word != null : "word can’t be null";
		
		char c = word.charAt(index);
		
		if(node == null){
			node = new Node(c);
		}
		
		if(c == node.getChar()){
			if(word.length() > index + 1){
				node.setChild(insert(node.getChild(), word, index + 1));
			}else{
				node.setWord(word.toString());
			}
		}else if(c < node.getChar()){
			node.setSmaller(insert(node.getSmaller(), word, index));
		}else {
			node.setLarger(insert(node.getLarger(), word, index));
		}
		return node;
	}
	
	private Node search(Node node, CharSequence word, int index) {
		// TODO Auto-generated method stub
		assert word != null : "word can’t be null";		
		
		if(node == null){
			return null;
		}
		
		char c = word.charAt(index);
		
		if(c == node.getChar()){
			if(word.length() > index + 1){
				node = search(node.getChild(), word, index + 1);
			}
		}else if(c < node.getChar()){
			node = search(node.getSmaller(), word, index);
		}else {
			node = search(node.getLarger(), word, index);
		}
		return node;
	}
	
	private void inOrderTraversal(Node node, List<String> words) {
		// TODO Auto-generated method stub
		
		assert words != null : "words can’t be null";		
		
		if(node == null){
			return;
		}
		inOrderTraversal(node.getSmaller(), words);
		if(node.isEndOfWord()){
			words.add(node.getWord());
		}
		inOrderTraversal(node.getChild(), words);
		inOrderTraversal(node.getLarger(), words);
	}
	
	private void patternMatch(Node node, CharSequence pattern, int index, List<String> words) {
		// TODO Auto-generated method stub
		assert pattern != null : "pattern can’t be null";
		assert words != null : "results can’t be null";
		
		if(node == null){
			return;
		}
		
		char c = pattern.charAt(index);
		
		if(c == WILDCART || c < node.getChar()){
			patternMatch(node.getSmaller(), pattern, index, words);
		}
		
		if(c == WILDCART || c == node.getChar()){
			if(index + 1 < pattern.length()){
				patternMatch(node.getChild(), pattern, index + 1, words);
			}else if(node.isEndOfWord()){
				words.add(node.getWord());
			}
		}
		
		if(c == WILDCART || c > node.getChar()){
			patternMatch(node.getLarger(), pattern, index, words);
		}
	}
	
	private Node iterativeSearch(Node node, CharSequence word, int index) {
		// TODO Auto-generated method stub
		assert word != null : "word can’t be null";			
//		int index = 0;
//		char c;
//		Node next = null;
//		while(node != null && index < word.length()){
//			next = node;
//			c = word.charAt(index);
//			if(c == node.getChar()){
//				node = node.getChild();
//				index ++;			
//			}else{
//				node = c < node.getChar() ? node.getSmaller() : node.getLarger();
//			}
//			
//		}
		while (node != null) {
			char c = word.charAt(index);
			if (c == node.getChar()) {
				if (index + 1 < word.length()) {
					node = node.getChild();
					index ++;
				} else {
					break;
				}
			} else {
				node = c < node.getChar() ? node.getSmaller() : node.getLarger();
				}
		}		
		return node;
	}

}
