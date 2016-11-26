package com.wrox.algorithms.stacks;

import junit.framework.TestCase;

public abstract class AbstractStackTestCase extends TestCase{
	
	protected static final String VALUE_A = "A";
	protected static final String VALUE_B = "B";
	protected static final String VALUE_C = "C";
	
	protected abstract Stack<String> createStack();
	
	public void testPushAndPop(){
		
		Stack<String> stack = createStack();
		
		stack.push(VALUE_B);
		stack.push(VALUE_A);
		stack.push(VALUE_C);
		
		assertEquals(3, stack.size());
		assertFalse(stack.isEmpty());
		
		assertSame(VALUE_C, stack.pop());
		assertEquals(2, stack.size());
		assertFalse(stack.isEmpty());
		
		assertSame(VALUE_A, stack.pop());
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		
		assertSame(VALUE_B, stack.pop());
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
		
		try {
			stack.pop();
			fail();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block			
		}
	}
	
	public void testPeek(){
		
		Stack<String> stack = createStack();
		
		stack.push(VALUE_B);
		stack.push(VALUE_A);
		
		assertEquals(2, stack.size());
		assertFalse(stack.isEmpty());		
		assertSame(VALUE_A, stack.peek());
		assertEquals(2, stack.size());
		assertFalse(stack.isEmpty());				
	}
	
	public void testCantPeekIntoAnEmptyStack() {
		
		Stack<String> stack = createStack();
		
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
		
		try {
			stack.peek();
			fail();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void testClear(){
		
		Stack<String> stack = createStack();
		
		stack.push(VALUE_B);
		stack.push(VALUE_A);
		stack.push(VALUE_C);
		
		assertEquals(3, stack.size());
		assertFalse(stack.isEmpty());
		
		stack.clear();
		
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
		
		try {
			stack.pop();
			fail();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block			
		}
		
		try {
			stack.peek();
			fail();
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
		}
		
	}
	

}
