package isochroneAPI.ParseGEOJSON;

public class FeatureList {
	private String type;
	private Geometry geometry;
	private Properties properties;
	
	public String getType(){
		return type;
	}
	
	public Geometry getGeometry(){
		return geometry;
	}
	
	public Properties getProperties(){
		return properties;
	}
	
}
