package de.hsmainz.bos.model;

/**
 * Class for BOS structure (bbox and interest) for requests.
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class BOS {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	/** The south. */
	private double south;

	/** The west. */
	private double west;

	/** The north. */
	private double north;

	/** The east. */
	private double east;

	/** The interest. */
	private String interest;

	// ****************************************
	// INIT/CONSTRUCTOR
	// ****************************************

	// ****************************************
	// GETTER/SETTER
	// ****************************************

	/**
	 * Gets the south.
	 *
	 * @return the south
	 */
	public double getSouth() {
		return this.south;
	}

	/**
	 * Sets the south.
	 *
	 * @param south
	 *            the new south
	 */
	public void setSouth(double south) {
		this.south = south;
	}

	/**
	 * Gets the west.
	 *
	 * @return the west
	 */
	public double getWest() {
		return this.west;
	}

	/**
	 * Sets the west.
	 *
	 * @param west
	 *            the new west
	 */
	public void setWest(double west) {
		this.west = west;
	}

	/**
	 * Gets the north.
	 *
	 * @return the north
	 */
	public double getNorth() {
		return this.north;
	}

	/**
	 * Sets the north.
	 *
	 * @param north
	 *            the new north
	 */
	public void setNorth(double north) {
		this.north = north;
	}

	/**
	 * Gets the east.
	 *
	 * @return the east
	 */
	public double getEast() {
		return this.east;
	}

	/**
	 * Sets the east.
	 *
	 * @param east
	 *            the new east
	 */
	public void setEast(double east) {
		this.east = east;
	}

	/**
	 * Gets the interest.
	 *
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * Sets the interest.
	 *
	 * @param interest
	 *            the new interest
	 */
	public void setInterest(String interest) {
		this.interest = interest;
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
