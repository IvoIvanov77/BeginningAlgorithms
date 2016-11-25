package com.wrox.algorithms.lists;

public class ArrayListTest extends AbstractListTestCase{

	@Override
	protected List<String> createList() {
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}
	
	public void testResizeBeyondInitialCapacity(){
		List<String> list = new ArrayList<>(1);
		
		list.add(VALUE_A);
		list.add(VALUE_A);
		list.add(VALUE_A);
		
		assertEquals(3, list.size());
		
		assertSame(VALUE_A, list.get(0));
		assertSame(VALUE_A, list.get(1));
		assertSame(VALUE_A, list.get(2));
	}
	
	public void testDeleteFromLastElementInArray(){
		List<String> list = new ArrayList<>(1);
		
		list.add(new String());
		list.delete(0);
	}

}
