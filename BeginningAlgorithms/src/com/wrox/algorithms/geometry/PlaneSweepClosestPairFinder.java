package com.wrox.algorithms.geometry;

import com.wrox.algorithms.bsearch.IterativeBinaryListSearcher;
import com.wrox.algorithms.bsearch.ListInserter;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sets.ListSet;
import com.wrox.algorithms.sets.Set;


public class PlaneSweepClosestPairFinder implements ClosestPairFinder {

	public static final PlaneSweepClosestPairFinder INSTANCE = new PlaneSweepClosestPairFinder();
	
	private static final ListInserter<Point> INSERTER = new ListInserter<>(
			new IterativeBinaryListSearcher<Point>(XYPointComparator.INSTANCE));
	
	private PlaneSweepClosestPairFinder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<Point> findClosestPair(Set<Point> points) {
		// TODO Auto-generated method stub
		assert points != null : "points can’t be null";
		if(points.size() < 2){
			return null;
		}
		
		List<Point> sortedPoints = sortPoints(points);
		
		Point p1 = sortedPoints.get(0);
		Point p2 = sortedPoints.get(1);
		
		return findClosestPair(p1, p2, sortedPoints);
	}

	private Set<Point> findClosestPair(Point p1, Point p2, List<Point> sortedPoints) {
		// TODO Auto-generated method stub
		Set<Point> result = createPointPair(p1, p2);
		
		double distance = p1.distance(p2);
		int dragPoint = 0;
		
		for (int i = 2; i < sortedPoints.size(); ++i) {
			Point r = sortedPoints.get(i);
			double sweepX = r.getX();
			double dragX = sweepX - distance;
			while ((sortedPoints.get(dragPoint)).getX() < dragX) {
				dragPoint ++;
			}
			for (int j = dragPoint; j < i; ++j) {
				Point test = (Point) sortedPoints.get(j);
				double checkDistance = r.distance(test);
				if (checkDistance < distance) {
					distance = checkDistance;
					result = createPointPair(r, test);
				}
			}
		}
		return result;
	}

	private Set<Point> createPointPair(Point p1, Point p2) {
		// TODO Auto-generated method stub
		Set<Point> result = new ListSet<>();
		result.add(p1);
		result.add(p2);
		return result;
		
	}

	private List<Point> sortPoints(Set<Point> points) {
		// TODO Auto-generated method stub
		List<Point> result = new ArrayList<>(points.size());
		Iterator<Point> i = points.iterator();
		for(i.first(); !i.isDone(); i.next()){
			INSERTER.insert(result, i.current());
		}
		return result;
	}

}
