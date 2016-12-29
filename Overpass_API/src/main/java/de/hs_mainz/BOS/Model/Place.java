package de.hs_mainz.BOS.Model;

public class Place {
	
	private String type;
	
	private int id;
	
	private double lat;
	
	private double lon;
	
	private Tags tags;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLng(double lon) {
		this.lon = lon;
	}
	public Tags getTags() {
		return tags;
	}
	public void setTags(Tags tags) {
		this.tags = tags;
	}
	
	
	
}
