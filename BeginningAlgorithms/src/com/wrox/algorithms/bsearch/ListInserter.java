package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.List;

public class ListInserter<T> {
	
	private final ListSearcher<T> searcher;

	public ListInserter(ListSearcher<T> searcher) {
		assert searcher != null : "searcher can’t be null";
		this.searcher = searcher;
	}

	public int insert(List<T> list, T value) {
		// TODO Auto-generated method stub
		assert list != null : "list can’t be null";
		
		int index = searcher.search(list, value);
		if(index < 0){
			index = -(index + 1);
		}
		list.insert(index, value);
		return index;
	}

	
	

}
