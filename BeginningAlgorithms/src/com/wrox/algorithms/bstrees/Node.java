package com.wrox.algorithms.bstrees;

public class Node<T> {
	
	private T value;
	private Node<T> parent;	
	private Node<T> leftChild;
	private Node<T> rightChild;
	private int size = 0;
	
	public Node(T value, Node<T> leftChild, Node<T> rightChild) {		
		this.value = value;
		this.size = 1;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		if(leftChild != null){			
			leftChild.setParent(this);
			size += leftChild.size;
		}
		if(rightChild != null){			
			rightChild.setParent(this);
			size += rightChild.size;
		}
	}

	public Node(T value) {		
		this(value, null, null);
	}

	public Node<T> minimum() {
		// TODO Auto-generated method stub
		Node<T> minimum = this;
		while(minimum.leftChild != null){
			minimum = minimum.leftChild;
		}
		return minimum;
	}
	
	public Node<T> maximum() {
		// TODO Auto-generated method stub
		Node<T> maximum = this;
		while(maximum.getRightChild() != null){
			maximum = maximum.getRightChild();
		}
		return maximum;
	}
	
	public Node<T> successor() {
		// TODO Auto-generated method stub
		Node<T> current = this;
		if(current.getRightChild() != null){
			return current.getRightChild().minimum();
		}
		while(current.isLarger()){							
			current = current.getParent();			
		}		
		return current.getParent();
	}
	
	public Node<T> predecessor() {
		// TODO Auto-generated method stub
		Node<T> current = this;
		if(current.getLeftChild() != null){
			return current.getLeftChild().maximum();
		}
		while(current.isSmaller()){							
			current = current.getParent();			
		}
		
		return current.getParent();
	}


	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}


	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	public boolean isSmaller() {
		// TODO Auto-generated method stub
		if(this.getParent() == null){
			return false;
		}
		return this.getParent().getLeftChild() == this;
	}

	public boolean isLarger() {
		// TODO Auto-generated method stub
		if(this.getParent() == null){
			return false;
		}
		return this.getParent().getRightChild() == this;
	}

	public int size() {		
		return size;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || object.getClass() != getClass()) {
			return false;
		}
		Node<T> other = (Node<T>) object;
		return getValue().equals(other.getValue())
			&& equalsLeftChild(other.getLeftChild())
			&& equalsRightChild(other.getRightChild());
	}

	private boolean equalsLeftChild(Node<T> other) {
		// TODO Auto-generated method stub
		return getLeftChild() == null && other == null
				|| getLeftChild() != null && getLeftChild().equals(other);
	}

	private boolean equalsRightChild(Node<T> other) {
		// TODO Auto-generated method stub
		return getRightChild() == null && other == null
				|| getRightChild() != null && getRightChild().equals(other);
	}
	
	protected boolean isLeaf(){
		return this.leftChild == null && this.rightChild == null;
	}
	
	protected boolean hasTwoChildren(){
		return this.leftChild != null && this.rightChild != null;
	}
	
	protected Node<T> getChild(){
		if(this.leftChild != null){
			return this.leftChild;
		}else{
			return this.rightChild;
		}
	}
	
	protected Node<T> recursiveMin(Node<T> node){
		if(node.leftChild == null){
			return node;
		}
		return recursiveMin(node.leftChild);
	}
	
	public Node<T> recursiveMinimum(){
		return recursiveMin(this);
	}
	
	
	public int getSizeRecurcively(){
		return recursiveSize(this);
	}
	
	public int height(){
		return recursiveHeight(this);
	}
	
	private int recursiveSize(Node<T> node){
		if(node == null){
			return 0;
		}
		int size = 1 +  recursiveSize(node.leftChild) + recursiveSize(node.rightChild);
		return size;
	}
	
	private int recursiveHeight(Node<T> node){
		if(node == null){
			return 0;
		}
		int left = 1 + recursiveHeight(node.leftChild);
		int right = 1 + recursiveHeight(node.rightChild);
		return  left > right ? left : right;
	}

}
