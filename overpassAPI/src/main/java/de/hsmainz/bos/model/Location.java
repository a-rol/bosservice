package de.hsmainz.bos.model;

/**
 * Class for geometry of the BOS --> location containing the coordinates.
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class Location {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	/** The lat. */
	private double lat;

	/** The lng. */
	private double lng;

	// ****************************************
	// INIT/CONSTRUCTOR
	// ****************************************

	// ****************************************
	// GETTER/SETTER
	// ****************************************

	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public double getLat() {
		return this.lat;
	}

	/**
	 * Sets the lat.
	 *
	 * @param lat
	 *            the new lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * Gets the lng.
	 *
	 * @return the lng
	 */
	public double getLng() {
		return this.lng;
	}

	/**
	 * Sets the lng.
	 *
	 * @param lng
	 *            the new lng
	 */
	public void setLng(double lng) {
		this.lng = lng;
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
