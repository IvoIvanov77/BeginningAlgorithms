package com.wrox.algorithms.geometry;

public class Point {
	
	private final double x;
	private final double y;

	public Point(double x, double y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	public double distance(Point point) {
		// TODO Auto-generated method stub
		double distance = Math.sqrt(Math.pow((this.getX() - point.getX()), 2) 
				+ Math.pow((this.getY() - point.getY()), 2));
		return distance;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	
	
	
	

}
