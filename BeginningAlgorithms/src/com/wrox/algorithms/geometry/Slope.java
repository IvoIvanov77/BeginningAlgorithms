package com.wrox.algorithms.geometry;

public class Slope {
	
	private final double rise;
	private final double travel;

	public Slope(double rise, double travel) {
		// TODO Auto-generated constructor stub
		this.rise = rise;
		this.travel = travel;
	}

	public boolean isVertical() {
		// TODO Auto-generated method stub
		return this.travel == 0;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(rise);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(travel);
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
		Slope other = (Slope) obj;
		if(this.isVertical() && other.isVertical()){
			return true;
		}
		if(this.isVertical() || other.isVertical()){
			return false;
		}		
		return this.asDouble() == other.asDouble();
	}

	public double asDouble() {
		// TODO Auto-generated method stub
		if (isVertical()) {
			throw new IllegalStateException("Vertical slope cannot be represented as double");
		}
		return this.rise / this.travel;
	}
	
	
}
