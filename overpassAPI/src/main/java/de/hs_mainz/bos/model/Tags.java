package de.hs_mainz.bos.model;

/**
 * Class for a parameter of BOS response --> Tags includes amenity and name
 * 
 * @author Angelique 
 * @since 28.12.2016
 */

public class Tags {
		
	//****************************************
    // CONSTANTS
    //****************************************

    //****************************************
    // VARIABLES
    //****************************************
		
	private String amenity;
	
	private String name;	
	
	//****************************************
    // INIT/CONSTRUCTOR
    //****************************************

    //****************************************
    // GETTER/SETTER
    //****************************************
	
	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
