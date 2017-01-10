package com.wrox.algorithms.geometry;

public class Line {
	
	private final Point p1;
	private final Point p2;
	private final Slope slope;

	public Line(Point p1, Point p2) {
		// TODO Auto-generated constructor stub
		assert p1 != null : "point defining a line cannot be null";
		assert p2 != null : "point defining a line cannot be null";
		this.p1 = p1;
		this.p2 = p2;
		this.slope = new Slope(p1.getY() - p2.getY(), p1.getX() - p2.getX());
	}

	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		if (!isWithin(p.getX(), this.p1.getX(), this.p2.getX())) {
			return false;
		}
		if (!isWithin(p.getY(), this.p1.getY(), this.p2.getY())) {
			return false;
		}
		if (slope.isVertical()) {
			return true;
		}
		return p.getY() == solveY(p.getX());
	}

	private double solveY(double x) {
		// TODO Auto-generated method stub
		return this.slope.asDouble() * x + base();
	}

	private double base() {
		// TODO Auto-generated method stub
		return this.p1.getY() - this.slope.asDouble()* this.p1.getX();
	}

	private boolean isWithin(double test, double bound1, double bound2) {
		// TODO Auto-generated method stub
		return test >= Math.min(bound1, bound2)
				&& test <= Math.max(bound1, bound2);
	}

	public boolean isParallelTo(Line line) {
		// TODO Auto-generated method stub
		return this.slope.equals(line.slope);
	}

	public Point intersectionPoint(Line line) {
		// TODO Auto-generated method stub
		if (isParallelTo(line)) {
			return null;
		}
		double x = getIntersectionXCoordinate(line);
		double y = getIntersectionYCoordinate(line, x);
		
		Point p = new Point(x, y);
		if(line.contains(p) && this.contains(p)){
			return p;
		}
		return null;
	}
	
//	The trick is that the coordinates of the point of intersection will make sense in either 
//	of the formulas for
//	the two lines. In other words, if the formula for the first line is as follows:
//	y = mx + b
//	And the formula for the second line is as follows:
//	y = nx + c
//	To find the point of intersection, use the following:
//	mx + b = nx +c
//	Rearrange that as follows:
//	mx – nx = c – b
//	Rearrange again:
//	x = (c – b) / (m – n)
	

	private double getIntersectionXCoordinate(Line line) {
		// TODO Auto-generated method stub
		if (this.slope.isVertical()) {
			return this.p1.getX();
		}
		if (line.slope.isVertical()) {
			return line.p1.getX();
		}
		return (line.base() - this.base()) / (this.slope.asDouble() - line.slope.asDouble());
	}

	private double getIntersectionYCoordinate(Line line, double x) {
		// TODO Auto-generated method stub
		if (this.slope.isVertical()) {
			return line.solveY(x);
		}
		return solveY(x);
	}

}
