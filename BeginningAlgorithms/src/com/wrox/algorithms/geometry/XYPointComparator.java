package com.wrox.algorithms.geometry;

import java.util.Comparator;

public class XYPointComparator implements Comparator<Point>{

	public static final XYPointComparator INSTANCE = new XYPointComparator();
	
	private XYPointComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Point p1, Point p2) {
		// TODO Auto-generated method stub
		int result = new Double(p1.getX()).compareTo(new Double(p2.getX()));
		if(result != 0){
			return result;
		}
		return new Double(p1.getY()).compareTo(new Double(p2.getY()));
	}

}
