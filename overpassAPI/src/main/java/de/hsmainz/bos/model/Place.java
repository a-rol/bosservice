package de.hsmainz.bos.model;

/**
 * Class for gathering the parameters of each BOS for response.
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class Place {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	/** The type. */
	private String type;

	/** The id. */
	private String id;

	/** The lat. */
	private double lat;

	/** The lon. */
	private double lon;

	/** The tags. */
	private Tags tags;

	// ****************************************
	// INIT/CONSTRUCTOR
	// ****************************************

	// ****************************************
	// GETTER/SETTER
	// ****************************************

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public double getLat() {
		return lat;
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
	 * Gets the lon.
	 *
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * Sets the lon.
	 *
	 * @param lon
	 *            the new lon
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public Tags getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags
	 *            the new tags
	 */
	public void setTags(Tags tags) {
		this.tags = tags;
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
