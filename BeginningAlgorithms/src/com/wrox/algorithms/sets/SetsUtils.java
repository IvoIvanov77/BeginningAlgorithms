package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.Iterator;

public class SetsUtils<T> {
	
	private Set<T> result;
	
	
	
	public SetsUtils(Set<T> result) {		
		this.result = result;
		this.result.clear();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean isEquals(Set one, Set two){
		assert one != null : "one can’t be null";
		assert two != null : "two can’t be null";
		if(one.size() != two.size()){
			return false;
		}
		Iterator i = one.iterator();		
		for(i.first(); !i.isDone(); i.next()){
			if(!two.contains(i.current())){
				return false;
			}
		}
		return true;
	}
	
		
	public Set<T> union(Set<T> one, Set<T> two){
		addAll(one);
		addAll(two);
		return this.result;
	}
	
	public Set<T> intersection(Set<T> one, Set<T> two){
		Iterator<T> i = one.iterator();
		for(i.first(); !i.isDone(); i.next()){
			if(two.contains(i.current())){				
				result.add(i.current());
			}
		}		
		return this.result;
	}
	
	public Set<T> difference(Set<T> one, Set<T> two){
		
		Set<T> bigger = one.size() > two.size() ? one : two;
		Set<T> smaller = one == bigger ? two : one;
		Iterator<T> i = bigger.iterator();
		for(i.first(); !i.isDone(); i.next()){
			if(!smaller.contains(i.current())){				
				result.add(i.current());
			}
		}		
		return this.result;
	}

	private void addAll(Set<T> set) {
		// TODO Auto-generated method stub
		Iterator<T> i = set.iterator();
		for(i.first(); !i.isDone(); i.next()){
			result.add(i.current());
		}
	}

}
