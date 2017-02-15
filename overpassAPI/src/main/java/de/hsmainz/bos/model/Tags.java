package de.hsmainz.bos.model;

/**
 * Class for a parameter of BOS response --> Tags includes amenity and name.
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class Tags {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	/** The amenity. */
	private String amenity;

	/** The name. */
	private String name;

	// ****************************************
	// INIT/CONSTRUCTOR
	// ****************************************

	// ****************************************
	// GETTER/SETTER
	// ****************************************

	/**
	 * Gets the amenity.
	 *
	 * @return the amenity
	 */
	public String getAmenity() {
		return amenity;
	}

	/**
	 * Sets the amenity.
	 *
	 * @param amenity
	 *            the new amenity
	 */
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	// ****************************************
	// PUBLIC METHODS
	// ****************************************

	// ****************************************
	// PRIVATE METHODS
	// ****************************************

	// ****************************************
	// INNER CLASSES
	// ****************************************

}
