package com.wrox.algorithms.stacks;

import com.wrox.algorithms.lists.AbstractListTestCase;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

public class UndoableListTest extends AbstractListTestCase {

	@Override
	protected List<String> createList() {
		// TODO Auto-generated method stub
		return new UndoableList<String>(new ArrayList<String>());
	}

	public void testUndoInsert() {

		UndoableList<String> list = new UndoableList<String>(new ArrayList<String>());

		assertFalse(list.canUndo());
		list.insert(0, VALUE_A);
		assertTrue(list.canUndo());

		list.undo();
		assertEquals(0, list.size());
		assertFalse(list.canUndo());
	}

	public void testUndoAdd() {

		UndoableList<String> list = new UndoableList<String>(new ArrayList<String>());

		assertFalse(list.canUndo());
		list.add(VALUE_A);
		assertTrue(list.canUndo());

		list.undo();
		assertEquals(0, list.size());
		assertFalse(list.canUndo());

	}

	public void testUndoDeleteByPosition() {

		UndoableList<String> list = new UndoableList<String>(
				new ArrayList<String>(new String[] { VALUE_A, VALUE_B }));

		assertFalse(list.canUndo());
		assertSame(VALUE_B, list.delete(1));
		assertTrue(list.canUndo());

		list.undo();

		assertEquals(2, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertFalse(list.canUndo());
	}

	public void testUndoDeleteByValue() {

		UndoableList<String> list = new UndoableList<String>(
				new ArrayList<String>(new String[] { VALUE_A, VALUE_B }));

		assertFalse(list.canUndo());
		assertTrue(list.delete(VALUE_B));
		assertTrue(list.canUndo());

		list.undo();

		assertEquals(2, list.size());
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_B, list.get(1));
		assertFalse(list.canUndo());
	}

	public void testUndoSet() {
		UndoableList<String> list = new UndoableList<String>(
				new ArrayList<String>(new String[] { VALUE_A }));

		assertFalse(list.canUndo());
		assertSame(VALUE_A, list.set(0, VALUE_B));
		assertTrue(list.canUndo());

		list.undo();

		assertEquals(1, list.size());
		assertSame(VALUE_A, list.get(0));
		assertFalse(list.canUndo());
	}

	public void testClearResetsUndoStack() {
		
		UndoableList<String> list = new UndoableList<>(new ArrayList<String>());
		assertFalse(list.canUndo());
		list.add(VALUE_A);
		assertTrue(list.canUndo());
		
		list.clear();
		
		assertFalse(list.canUndo());
	}
	
	public void testUndoMultiple(){
		
		UndoableList<String> list = new UndoableList<>(new ArrayList<String>());
		assertFalse(list.canUndo());
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		
		assertTrue(list.canUndo());
		list.undo();
		
		assertEquals(1, list.size());
		assertSame(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.delete(0);
		
		list.undo();
		assertEquals(1, list.size());
		assertSame(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.undo();
		assertEquals(0, list.size());		
		assertFalse(list.canUndo());
	}
}
