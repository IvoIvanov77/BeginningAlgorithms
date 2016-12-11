package com.wrox.algorithms.sorting;

import java.util.Comparator;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.queues.HeapOrderedListPriorityQueue;
import com.wrox.algorithms.queues.Queue;

public class PriorityQueueListSorter<T> implements ListSorter<T>{
	
	private final Comparator<T> comparator;	

	public PriorityQueueListSorter(Comparator<T> comparator) {		
		this.comparator = comparator;
	}


	@Override
	public List<T> sort(List<T> list) {
		// TODO Auto-generated method stub
		Comparator<T> reverseComparator = new ReverseCompalator<>(this.comparator);
		Queue<T> queue = new HeapOrderedListPriorityQueue<>(reverseComparator);
		Iterator<T> i = list.iterator();
		i.first();
		while(!i.isDone()){
			queue.enqueue(i.current());
			i.next();
		}
		List<T> result = new ArrayList<>(list.size());
		while(!queue.isEmpty()){
			result.add(queue.dequeue());
		}
		return result;
	}

}
