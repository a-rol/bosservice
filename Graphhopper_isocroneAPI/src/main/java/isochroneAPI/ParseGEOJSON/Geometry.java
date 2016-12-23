package isochroneAPI.ParseGEOJSON;

import java.util.List;

public class Geometry {
	private String type;
	private List<List<List<Double>>> coordinates;

	
	public List<List<List<Double>>> getlatlng(){
		return coordinates;
	}
	public String getType(){
		return type;
	}
}
