package isochroneAPI.ParseGEOJSON;

import java.util.List;

public class Polygon {
	
	
	
	private String type;
	private List<FeatureList> features;
	
	public List<FeatureList> getFeature() {
            return features;
	}
	
	public String getType(){
		return type;
	}
}
