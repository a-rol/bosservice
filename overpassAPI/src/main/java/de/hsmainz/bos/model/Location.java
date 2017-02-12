package de.hs_mainz.bos.model;

/**
 * Class for geometry of the BOS --> location containing the coordinates
 * 
 * @author Angelique 
 * @since 28.12.2016
 */

public class Location {
	
	//****************************************
    // CONSTANTS
    //****************************************

    //****************************************
    // VARIABLES
    //****************************************
	
	private double lat;
	private double lng;
		
	//****************************************
    // INIT/CONSTRUCTOR
    //****************************************

    //****************************************
    // GETTER/SETTER
    //****************************************
	
	public double getLat() {
		return this.lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public double getLng() {
		return this.lng;
	}
	
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	//****************************************
    // PUBLIC METHODS
    //****************************************

    //****************************************
    // PRIVATE METHODS
    //****************************************

    //****************************************
    // INNER CLASSES
    //****************************************

}
