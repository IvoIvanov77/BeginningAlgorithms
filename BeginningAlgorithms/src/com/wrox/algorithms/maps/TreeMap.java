package com.wrox.algorithms.maps;

import java.util.Comparator;

import com.wrox.algorithms.bstrees.Node;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.sorting.NaturalComparator;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
	
	private final Comparator<K> comparator;
	private Node<Map.Entry<K, V>> root;
	private int size;
	
	public TreeMap() {
		this(new NaturalComparator<K>());
	}

	public TreeMap(Comparator<K> comparator) {
		assert comparator != null : "comparator can’t be null";
		this.comparator = comparator;
	}

	@Override
	public Iterator<Map.Entry<K, V>> iterator() {
		// TODO Auto-generated method stub
		return new EntryKeyIterator<>(root);
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Node<Map.Entry<K, V>> node = search(key);		
		return node != null ? getEntryValue(node) : null;
	}	

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		Node<Map.Entry<K, V>> node = search(key);
		if(node != null){
			DefaultEntry<K, V> entry = (DefaultEntry<K, V>) node.getValue();
			return setEntryValue(entry, value);
		}
		return add(key, value);
	}

	@Override
	public V delete(K key) {
		// TODO Auto-generated method stub
		Node<Map.Entry<K, V>> node = search(key);
		if(node == null){
			return null;
		}
		
		Node<Map.Entry<K, V>> deleted = node.getLeftChild() != null && node.getRightChild() != null ?
				node.successor() : node;
		assert deleted != null : "deleted can’t be null";
		
		Node<Map.Entry<K, V>> replacement = deleted.getLeftChild() != null ? deleted.getLeftChild() :
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
			Map.Entry<K, V> deletedValue = node.getValue();			
			node.setValue(deleted.getValue());
			deleted.setValue(deletedValue);
		}
		size --;
		return getEntryValue(deleted);
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return search(key) != null;
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

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.root = null;
		this.size = 0;
		
	}
	
	private Node<Map.Entry<K, V>> search(K key) {
		// TODO Auto-generated method stub
		assert key != null : "key can’t be null";
		Node<Map.Entry<K, V>> node = this.root;
		while(node != null){			
			int cmp = this.comparator.compare(key, getEntryKey(node));
			if(cmp == 0){
				break;
			}
			node = cmp < 0 ? node.getLeftChild() : node.getRightChild();
		}
		return node;
	}
	
	private K getEntryKey(Node<Map.Entry<K, V>> node){
		return node.getValue().getKey();
	}
	
	private V getEntryValue(Node<Map.Entry<K, V>> node){
		return node.getValue().getValue();
	}
	
	private V setEntryValue(DefaultEntry<K, V> entry, V value){
		return entry.setValue(value);
	}
	
	private V add(K key, V value) {
		// TODO Auto-generated method stub
		Node<Map.Entry<K, V>> parent = null;
		Node<Map.Entry<K, V>> node = this.root;
		int cmp = 0;
		
		while(node != null){
			parent = node;
			cmp = this.comparator.compare(key, getEntryKey(node));			
			node = cmp < 0 ? node.getLeftChild() : node.getRightChild();
		}
		Map.Entry<K, V> entry = new DefaultEntry<K, V>(key, value);
		Node<Map.Entry<K, V>> inserted = new Node<Map.Entry<K, V>>(entry);
		inserted.setParent(parent);
		
		if(parent == null){
			this.root = inserted;
		}else if(cmp < 0){
			parent.setLeftChild(inserted);
		}else{
			parent.setRightChild(inserted);
		}
		this.size ++;
		return null;
	}

	
}
