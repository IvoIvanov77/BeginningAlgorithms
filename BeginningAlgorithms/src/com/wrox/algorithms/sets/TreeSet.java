package com.wrox.algorithms.sets;

import java.util.Comparator;

import com.wrox.algorithms.bstrees.Node;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.sorting.NaturalComparator;

public class TreeSet<T extends Comparable<T>> implements Set<T> {
	
	private final Comparator<T> comparator;
	private Node<T> root;
	private int size;
		

	public TreeSet() {
		this(new NaturalComparator<T>());
	}

	public TreeSet(Comparator<T> comparator) {
		assert comparator != null : "comparator can’t be null";
		this.comparator = comparator;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ValueIterator<>(this.root);
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		Node<T> parent = null;
		Node<T> node = this.root;
		int cmp = 0;
		
		while(node != null){
			parent = node;
			cmp = this.comparator.compare(value, node.getValue());
			if(cmp == 0){
				return false;
			}
			node = cmp < 0 ? node.getLeftChild() : node.getRightChild();
		}
		Node<T> inserted = new Node<T>(value);
		inserted.setParent(parent);
		
		if(parent == null){
			this.root = inserted;
		}else if(cmp < 0){
			parent.setLeftChild(inserted);
		}else{
			parent.setRightChild(inserted);
		}
		this.size ++;
		return true;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		Node<T> node = search(value);
		if(node == null){
			return false;
		}
		
		Node<T> deleted = node.getLeftChild() != null && node.getRightChild() != null ?
				node.successor() : node;
		assert deleted != null : "deleted can’t be null";
		
		Node<T> replacement = deleted.getLeftChild() != null ? deleted.getLeftChild() :
			deleted.getRightChild();
		if(replacement != null){
			replacement.setParent(deleted.getParent());
		}
		
		if(deleted == this.root){
			this.root = replacement;
		}else if(deleted.isSmaller()){
			deleted.getParent().setLeftChild(replacement);
		}else {
			deleted.getParent().setRightChild(replacement);
		}
		
		if(deleted != node){
			T deletedValue = node.getValue();			
			node.setValue(deleted.getValue());
			deleted.setValue(deletedValue);
		}
		size --;
		return true;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return search(value) != null;
	}	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.root = null;
		this.size = 0;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.root == null;
	}
	
	private Node<T> search(T value) {
		// TODO Auto-generated method stub
		assert value != null : "value can’t be null";
		Node<T> node = this.root;
		while(node != null){
			int cmp = this.comparator.compare(value, node.getValue());
			if(cmp == 0){
				break;
			}
			node = cmp < 0 ? node.getLeftChild() : node.getRightChild();
		}
		return node;
	}

}
