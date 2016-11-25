package com.wrox.algorithms.iteration;

public class Test {

	public static void main(String[] args) {
		
		String[] array = {"A", "B", "C", "A", "Q", "Z", "A"};
		Iterator<String> iterator = new ArrayIterator<>(array);
		iterator.first();
		while(!iterator.isDone()){			
			System.out.println(iterator.current());
			iterator.next();
		}
		System.out.println();
		FilterIterator<String> filter = new FilterIterator<>(iterator, new Predicate() {
			
			@Override
			public boolean evaluate(Object object) {
				
				return object.equals("A");
			}
		});
		
		filter.first();
		while(!filter.isDone()){			
			System.out.println(filter.current());
			filter.next();
		}
		
		RecursivePowerCalculator calc = RecursivePowerCalculator.INSTANCE;
		System.out.println(calc.calculate(2, 3));

	}

}
