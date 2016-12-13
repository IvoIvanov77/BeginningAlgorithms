package com.wrox.algorithms.bstrees;

import java.util.Comparator;

public class BinarySearchTree<T> {
	
	private final Comparator<T> comparator;
	private Node<T> root;

	public BinarySearchTree(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator can’t be null";
		this.comparator = comparator;
	}

	public void insert(T value) {
		
		// TODO Auto-generated method stub
		
	}

	public Node<T> getRoot() {
		// TODO Auto-generated method stub
		return this.root;
	}

	public Node<T> search(T value) {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		return null;
	}

	public Node<T> delete(T value) {
		// TODO Auto-generated method stub
		return null;
	}

}
