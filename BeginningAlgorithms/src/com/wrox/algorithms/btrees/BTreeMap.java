package com.wrox.algorithms.btrees;

import java.util.Comparator;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.*;
import com.wrox.algorithms.maps.DefaultEntry;
import com.wrox.algorithms.maps.Map;


public class BTreeMap<K, V> implements Map<K, V> {

	private static final int MIN_KEYS_PER_NODE = 2;
	
	private final Comparator<K> comparator;
	private final int maxKeysPerNode;
	private Node root;
	private int size;

	public BTreeMap(Comparator<K> comparator, int maxKeysPerNode) {
		// TODO Auto-generated constructor stub
		assert comparator != null : "comparator can’t be null";
		assert maxKeysPerNode >= MIN_KEYS_PER_NODE : "maxKeysPerNode can’t be < " +
		MIN_KEYS_PER_NODE;
		this.comparator = comparator;
		this.maxKeysPerNode = maxKeysPerNode;
		clear();
	}

	@Override
	public Iterator<Map.Entry<K, V>> iterator() {
		// TODO Auto-generated method stub		
		List<Map.Entry<K, V>> list = new ArrayList<>(this.size);
		this.root.traverse(list);
		return list.iterator();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Entry<K, V> entry = root.search(key);
		return entry != null ? entry.getValue() : null;
	}

	@Override
	public V set(K key, V value) {
		// TODO Auto-generated method stub
		V oldValue = this.root.set(key, value);
		if(this.root.isFull()){
			Node newRoot = new Node(false);
			root.split(newRoot, 0);
			this.root = newRoot;
		}
		return oldValue;
	}

	@Override
	public V delete(K key) {
		// TODO Auto-generated method stub
		Entry<K, V> entry = root.search(key);
		if(entry == null){
			return null;
		}
		entry.setDeleted(true);
		this.size --;
		return entry.setValue(null);
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return this.root.search(key) != null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.root = new Node(true);
		this.size = 0;
		
	}

	private final class Node {
		
		private final List<Entry<K, V>> entries = new ArrayList<>(maxKeysPerNode + 1);
		private final List<Node> children;

		public Node(boolean leaf) {
			// TODO Auto-generated constructor stub
			this.children = !leaf ? new ArrayList<>(maxKeysPerNode + 2) : new EmptyList<>();
		}

		public void split(Node parent, int insertionPoint) {
			// TODO Auto-generated method stub
			assert parent != null : "parent can’t be null";
			
			Node sibling = new Node(isLeaf());
			int middle = this.entries.size() / 2;
			
			move(this.entries, sibling.entries, middle + 1);
			move(this.children, sibling.children, middle + 1);
			
			parent.entries.insert(insertionPoint, entries.delete(middle));
			if (parent.children.isEmpty()) {
				parent.children.insert(insertionPoint, this);
			}
			parent.children.insert(insertionPoint + 1, sibling);
			
		}
		
		public void traverse(List<Map.Entry<K, V>> list) {
			assert list != null : "list can’t be null";
			Iterator<Node> children = this.children.iterator();
			Iterator<Entry<K, V>> entries = this.entries.iterator();
			children.first();
			entries.first();
			while (!children.isDone() || !entries.isDone()) {
				if (!children.isDone()) {
					children.current().traverse(list);
					children.next();
				}
				if (!entries.isDone()) {
					Entry<K, V> entry =  entries.current();
					if (!entry.isDeleted()) {
						list.add(entry);
					}
					entries.next();
				}
			}
		}

		private <T> void move(List<T> source, List<T> target, int from ) {
			// TODO Auto-generated method stub
			assert source != null : "source can’t be null";
			assert target != null : "target can’t be null";
			while(from < source.size()){
				target.add(source.delete(from));
			}			
		}

		public boolean isFull() {
			// TODO Auto-generated method stub
			return entries.size() > maxKeysPerNode;
		}

		public V set(K key, V value) {
			// TODO Auto-generated method stub
			int index = indexOf(key);
			if(index >= 0){
				return this.entries.get(index).setValue(value);
			}
			return set(key, value, -(index + 1));
		}

		private V set(K key, V value, int index) {
			// TODO Auto-generated method stub
			if(isLeaf()){
				this.entries.insert(index, new Entry<>(key, value));
				size ++;
				return null;
			}
			Node child = this.children.get(index);
			V oldValue = child.set(key, value);
			if(child.isFull()){
				child.split(this, index);
			}
			return oldValue;
		}

		public Entry<K, V> search(K key) {
			// TODO Auto-generated method stub
			int index = indexOf(key);
			if(index >= 0){
				Entry<K, V> entry = this.entries.get(index);
				return !entry.isDeleted() ? entry : null;
			}
			return !isLeaf() ? this.children.get(-(index + 1)).search(key) : null;
		}

		private boolean isLeaf() {
			// TODO Auto-generated method stub
			return this.children.getClass() == EmptyList.class;
		}

		private int indexOf(K key) {
			// TODO Auto-generated method stub
			int lowerIndex = 0;
			int upperIndex = this.entries.size() - 1;
			
			while(lowerIndex <= upperIndex){
				int index = lowerIndex + (upperIndex - lowerIndex) / 2;
				int cmp = comparator.compare(key, this.entries.get(index).getKey());
				if(cmp == 0){
					return index;
				}else if(cmp < 0){
					upperIndex = index - 1;
				}else {
					lowerIndex = index + 1;
				}				
			}
			return -(lowerIndex + 1);
		}
	}
	
	private static final class Entry<K, V> extends DefaultEntry<K, V> {
		
		private boolean deleted;

		public Entry(K key, V value) {
			super(key, value);
			// TODO Auto-generated constructor stub
		}

		public boolean isDeleted() {
			return deleted;
		}

		public void setDeleted(boolean deleted) {
			this.deleted = deleted;
		}

		
		
	}
}
