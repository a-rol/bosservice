package de.hs_mainz.bos.model;

/**
 * Class for GeoJsonFeature structure ( with type, name, geometry and properties)
 * 
 * @author Angelique
 * @since 28.12.2016
 */

public class GeoJsonFeature {
	
	//****************************************
    // CONSTANTS
    //****************************************
	
    //****************************************
    // VARIABLES
    //****************************************
		
	private String type;
	private GeoJsonProperties properties;
	private GeoJsonGeometry geometry;
	
    //****************************************
    // INIT/CONSTRUCTOR
    //****************************************
	
    //****************************************
    // GETTER/SETTER
    //****************************************
	
	public String getType() {
		return type;
	}
	
	public GeoJsonProperties getGeoJsonProperties() {
		return properties;
	}
	
	public GeoJsonGeometry getGeoJsonGeometry() {
		return geometry;
	}
	
    //****************************************
    // PUBLIC METHODS
    //****************************************

	public static class GeoJsonGeometry {
		
		private String type;
		private double[] coordinates;
		public GeoJsonGeometry (String type, double[] coordinates) {
			this.type = type;
			this.coordinates = coordinates;
		}
		public String getType() {
			return this.type;
		}
		
		public double[] getCoordinates() {
			return this.coordinates;
		}
	}
	
	public static class GeoJsonProperties {
		private String name;
		
		public GeoJsonProperties(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
	}
		
	public GeoJsonFeature(String type, GeoJsonProperties geoJsonProperties, GeoJsonGeometry geometry) {
		this.type = type;
		this.properties = geoJsonProperties;
		this.geometry = geometry;
	}
			
    //****************************************
    // PRIVATE METHODS
    //****************************************
	
    //****************************************
    // INNER CLASSES
    //****************************************
	
	/**
	 * ({type":"FeatureCollection","features":[
	 * {"type":"Feature","properties":{"name":"Freiwillige Feuerwehr Sossenheim"},
	 * "geometry":{"type":"Point","coordinates":[8.5689493 (lon),50.1214732 (lat)]}},
	 */

}
