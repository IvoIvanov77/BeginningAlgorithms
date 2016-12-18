package com.wrox.algorithms.bstrees;

import com.wrox.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

	private Node<String> a;
	private Node<String> d;
	private Node<String> f;
	private Node<String> h;
	private Node<String> i;
	private Node<String> k;
	private Node<String> l;
	private Node<String> m;
	private Node<String> p;
	private Node<String> root;
	private BinarySearchTree<String> tree;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();

		this.a = new Node<>("A");
		this.h = new Node<>("H");
		this.k = new Node<>("K");
		this.p = new Node<>("P");
		this.f = new Node<>("F", null, h);
		this.m = new Node<>("M", null, p);
		this.d = new Node<>("D", a, f);
		this.l = new Node<>("L", k, m);
		this.i = new Node<>("I", d, l);
		this.root = i;
		tree = new BinarySearchTree<>(new NaturalComparator<String>());

		tree.insert(i.getValue());
		tree.insert(d.getValue());
		tree.insert(l.getValue());
		tree.insert(a.getValue());
		tree.insert(f.getValue());
		tree.insert(k.getValue());
		tree.insert(m.getValue());
		tree.insert(h.getValue());
		tree.insert(p.getValue());
	}

	public void testInsert() {
		assertEquals(root, tree.getRoot());
	}

	public void testSearch() {
		assertEquals(a, tree.search(a.getValue()));
		assertEquals(d, tree.search(d.getValue()));
		assertEquals(f, tree.search(f.getValue()));
		assertEquals(h, tree.search(h.getValue()));
		assertEquals(i, tree.search(i.getValue()));
		assertEquals(k, tree.search(k.getValue()));
		assertEquals(l, tree.search(l.getValue()));
		assertEquals(m, tree.search(m.getValue()));
		assertEquals(p, tree.search(p.getValue()));
		assertNull(tree.search("UNKNOWN"));
	}
	
	public void testRecursiveSearch() {
		assertEquals(a, tree.recursiveSearch(a.getValue()));
		assertEquals(d, tree.recursiveSearch(d.getValue()));
		assertEquals(f, tree.recursiveSearch(f.getValue()));
		assertEquals(h, tree.recursiveSearch(h.getValue()));
		assertEquals(i, tree.recursiveSearch(i.getValue()));
		assertEquals(k, tree.recursiveSearch(k.getValue()));
		assertEquals(l, tree.recursiveSearch(l.getValue()));
		assertEquals(m, tree.recursiveSearch(m.getValue()));
		assertEquals(p, tree.recursiveSearch(p.getValue()));
		assertNull(tree.recursiveSearch("UNKNOWN"));
	}

	public void testDeleteLeafNode() {
		Node<String> deleted = tree.delete(h.getValue());
		assertNotNull(deleted);
		assertEquals(h.getValue(), deleted.getValue());
		f.setRightChild(null);
		assertEquals(root, tree.getRoot());
	}

	public void testDeleteNodeWithOneChild() {
		Node<String> deleted = tree.delete(m.getValue());
		assertNotNull(deleted);
		assertEquals(m.getValue(), deleted.getValue());
		l.setRightChild(p);
		assertEquals(root, tree.getRoot());
	}

	public void testDeleteNodeWithTwoChildren() {
		Node<String> deleted = tree.delete(i.getValue());
		assertNotNull(deleted);
		assertEquals(i.getValue(), deleted.getValue());
		i.setValue(k.getValue());
		l.setLeftChild(null);
		assertEquals(root, tree.getRoot());
	}

	public void testDeleteRootNodeUntilTreeIsEmpty() {
		while (tree.getRoot() != null) {
			String key = tree.getRoot().getValue();
			Node<String> deleted = tree.delete(key);
			assertNotNull(deleted);
			assertEquals(key, deleted.getValue());
		}
	}
	
	public void testPrintInOrder(){
		System.out.println("Iterative in-order: ");
		tree.printInOrder();
	}
	
	public void testRecursivePrintInOrder(){
		System.out.println("Recursive in-order: ");
		tree.printRecursiveInOrder();
	}
	
	public void testPreOrder(){
		System.out.println("Pre-order: ");
		tree.printPreOrder();
	}
	
	public void testPostOrder(){
		System.out.println("Post-order: ");
		tree.printPostOrder();
	}
}


