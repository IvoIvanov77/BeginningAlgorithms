package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;

public class ListUtil {
	
	public static <T> String toString(List<T> list){
		Iterator<T> i = list.iterator();
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		if(!list.isEmpty()){			
			for(i.first(); !i.isDone(); i.next()){
				builder.append(i.current().toString()).append(", ");				
			}
			builder.setLength(builder.length() - 2);
		}		
		builder.append("]");
		return builder.toString();
	}
	
	public static <T> int indexOf(List<T> list, T value){
		int index = 0;
		Iterator<T> i = list.iterator();
		for(i.first(); !i.isDone(); i.next()){
			if(value.equals(i.current())){
				return index;
			}
			index ++;
		}
		return - 1;
	}

}
