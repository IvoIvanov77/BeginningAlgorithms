package com.wrox.algorithms.tstrees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.*;

public class CrosswordHelper {
	
	private CrosswordHelper(){
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		assert args != null : "args can’t be null";
		if (args.length < 2) {
		System.out.println("Usage CrosswordHelper <word-list> <pattern>");
		System.exit(-1);
		}
		searchForPattern(loadWords(args[0]), args[1]);

	}

	private static void searchForPattern(TernarySearchTree tree, String pattern) {
		// TODO Auto-generated method stub		
		assert tree != null : "tree can’t be null";
		System.out.println("Searching for pattern ‘" + pattern + "‘...");
		
		List<String> words = new LinkedList<>();		
		tree.patternMatch(pattern, words);
		
		Iterator<String> i = words.iterator();
		
		for(i.first(); !i.isDone(); i.next()){
			System.out.println(i.current());
		}
	}

	private static TernarySearchTree loadWords(String fileName) throws IOException {
		// TODO Auto-generated method stub
		TernarySearchTree tree = new TernarySearchTree();
		
		System.out.println("Loading words from ‘" + fileName + "‘...");
		
		BufferedReader rider = new BufferedReader(new FileReader(fileName));
		
		String word;
		while((word = rider.readLine()) != null){
			tree.add(word);
		}
		rider.close();
		return tree;
	}

}
