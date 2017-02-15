package de.hsmainz.bos.model;

import java.util.List;

/**
 * Class for collecting all features in a list and a type --> for constructing
 * the GeoJson.
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class GeoJsonFeatureCollection {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	/** The type. */
	private String type;

	/** The features. */
	private List<GeoJsonFeature> features;

	// ****************************************
	// INIT/CONSTRUCTOR
	// ****************************************

	// ****************************************
	// GETTER/SETTER
	// ****************************************

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public List<GeoJsonFeature> getList() {
		return this.features;
	}

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

	// ****************************************
	// PUBLIC METHODS
	// ****************************************

	/**
	 * Instantiates a new geo json feature collection.
	 *
	 * @param type
	 *            the type
	 * @param features
	 *            the features
	 */
	public GeoJsonFeatureCollection(String type, List<GeoJsonFeature> features) {
		this.type = type;
		this.features = features;
	}

	// ****************************************
	// PRIVATE METHODS
	// ****************************************

	// ****************************************
	// INNER CLASSES
	// ****************************************

	/**
	 * structure of the GeoJson-file ({type":"FeatureCollection","features":[
	 * {"type":"Feature","properties":{"name":"Freiwillige Feuerwehr
	 * Sossenheim"}, "geometry":{"type":"Point","coordinates":[8.5689493
	 * (lon),50.1214732 (lat)]}},
	 */

}
