package com.wrox.algorithms.iteration;

public final class AndPredicate implements Predicate{
	
	private final Predicate one;
	private final Predicate two;
	
	public AndPredicate(Predicate one,  Predicate two){
		assert !one.equals(null);
		assert !two.equals(null);
		this.one = one;
		this.two = two;
	}

	@Override
	public boolean evaluate(Object object) {
		// TODO Auto-generated method stub
		return one.evaluate(object) && two.evaluate(object);
	}

}
