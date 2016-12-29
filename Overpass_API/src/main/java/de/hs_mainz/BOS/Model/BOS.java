package de.hs_mainz.BOS.Model;

public class BOS {
	
	private double south;
	
	private double west;
	
	private double north;
	
	private double east;
	
	private String interest;
		
	public double getSouth() {
		return this.south;
	}
	
	public void setSouth( double south) {
		this.south = south;
	}
	
	public double getWest() {
		return this.west;
	}
	
	public void setWest( double west) {
		this.west = west;
	}
	
	public double getNorth() {
		return this.north;
	}
	
	public void setNorth( double north) {
		this.north = north;
	}
	
	public double getEast() {
		return this.east;
	}
	
	public void setEast( double east) {
		this.east = east;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

}
