package de.hs_mainz.BOS.Model;

import java.util.List;

public class GeoJsonFeatureCollection {
	private String type;
	private List<GeoJsonFeature> features;
	
	public GeoJsonFeatureCollection (String type, List<GeoJsonFeature> features) {
		this.type = type;
		this.features = features;
	}
	
	public List<GeoJsonFeature> getList() {
		return this.features;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * ({type":"FeatureCollection","features":[
	 * {"type":"Feature","properties":{"name":"Freiwillige Feuerwehr Sossenheim"},
	 * "geometry":{"type":"Point","coordinates":[8.5689493 (lon),50.1214732 (lat)]}},
	 */
	
}
