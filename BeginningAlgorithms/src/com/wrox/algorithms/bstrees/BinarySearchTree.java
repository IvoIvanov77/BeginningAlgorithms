package com.wrox.algorithms.bstrees;

import java.util.Comparator;

import com.wrox.algorithms.lists.List;

public class BinarySearchTree<T> {
	
	private final Comparator<T> comparator;
	private Node<T> root;

	public BinarySearchTree(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator can’t be null";
		this.comparator = comparator;
	}

	public void insert(T value) {
		
		Node<T> parent = this.root;
		Node<T> node = null;
		while(parent != null){	
			node = parent;
			int cmp = this.comparator.compare(value, parent.getValue());
			if(cmp <= 0){
				parent = parent.getLeftChild();
			}else {
				parent = parent.getRightChild();
			}
		}
		Node<T> insertion = new Node<T>(value);
		if(node == null){
			this.root = insertion;
		}else if(this.comparator.compare(value, node.getValue()) <= 0){
			node.setLeftChild(insertion);
			insertion.setParent(node);
		}else {
			node.setRightChild(insertion);
			insertion.setParent(node);
		}
		
		
	}

	public Node<T> getRoot() {
		// TODO Auto-generated method stub
		return this.root;
	}
	
//	1. Start at the root node.
//	2. If there is no current node, the search value was not found and you are done. Otherwise,
//	proceed to step 3.
//	3. Compare the search value with the key for the current node.
//	4. If the keys are equal, then you have found the search key and are done. Otherwise, proceed to
//	step 5.
//	5. If the search key sorts lower than the key for the current node, then follow the left link and go to
//	step 2.
//	6. Otherwise, the search key must sort higher than the key for the current node, so follow the right
//	link and go to step 2.

	public Node<T> search(T value) {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		Node<T> current = this.root;
		
		while(current != null){
			
			int cmp = this.comparator.compare(value, current.getValue());
			if(cmp == 0){
				return current;
			}else if(cmp < 0){
				current = current.getLeftChild();
			}else{
				current = current.getRightChild();
			}
		}
		return current;
	}
	public Node<T> recursiveSearch(T value){
		assert value != null : "value can’t be null";
		return searchRecursive(root, value);
	}
	
	private Node<T> searchRecursive(Node<T> start, T value){
		if(start == null){
			return null;
		}
		if(start.getValue() == value){
			return start;
		}		
		if(comparator.compare(value, start.getValue()) < 0){
			return searchRecursive(start.getLeftChild(), value);
		}else {
			return searchRecursive(start.getRightChild(), value);
		}
		
	}
//	❑ No children (a leaf), in which case you can simply remove it.
//	❑ One child (either left or right), in which case you can replace the deleted node with its child.
//	❑ Two children, in which case you swap the node with its successor and try again with either case
//	1 or case 2 as appropriate.
	
	public Node<T> delete(T value) {
		// TODO Auto-generated method stub
		Node<T> node = search(value);
		Node<T> toDelete = node;
		if(node == null){
			return null;
		}
		if(node.hasTwoChildren()){
			node.setValue(node.successor().getValue());
			toDelete = node.successor();
			toDelete.setValue(value);
		}
		Node<T> replacement = toDelete.getChild();
		if(replacement != null){ 
			replacement.setParent(toDelete.getParent());
		}
		if(toDelete == this.root){
			this.root = replacement;
		}else if(toDelete.isSmaller()){
			toDelete.getParent().setLeftChild(toDelete.getChild());
		}else {
			toDelete.getParent().setRightChild(toDelete.getChild());
		}		
		return toDelete;
	}
	
	public void printInOrder(){
		Node<T> node = this.root.minimum();
		while(node != null){
			System.out.print(node);
			node = node.successor();
		}
		System.out.println();
	}
	
	public void printRecursiveInOrder(){
		recursiveInOrder(root.minimum());
		System.out.println();
	}
//	I, D, A, F, H, L, K, M, P.
	public void printPreOrder(){
		recursivePreOrder(root);
		System.out.println();
	}
//	A, H, F, D, K, P, M, L, I.
	public void printPostOrder(){
		recursivePostOrder(root);
		System.out.println();
	}
	
	private void recursiveInOrder(Node<T> start){
		if(start == null){
			return;
		}
		System.out.print(start);
		recursiveInOrder(start.successor());		
	}
	
	private void recursivePreOrder(Node<T> start){
		if(start == null){
			return;
		}
		System.out.print(start);		
		recursivePreOrder(start.getLeftChild());
		recursivePreOrder(start.getRightChild());
	}
	
	private void recursivePostOrder(Node<T> start){
		if(start == null){
			return;
		}
		recursivePostOrder(start.getLeftChild());
		recursivePostOrder(start.getRightChild());
		System.out.print(start);
	}
	
	public void insertFromSotrtedList(List<T> list){
		insertRecurcively(list, 0, list.size() - 1);
	}
	
	private void insertRecurcively(List<T> list, int start, int end){
		if(start > end){
			return;
		}
		int midle = start + (end - start) / 2;
		insert(list.get(midle));
		insertRecurcively(list, start, midle - 1);
		insertRecurcively(list, midle + 1, end);
	}
	


	
	
//	public void setRoot(Node<T> i) {
//		this.root = i;
//		
//	}

}
