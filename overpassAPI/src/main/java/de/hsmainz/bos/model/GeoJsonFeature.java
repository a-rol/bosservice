package de.hsmainz.bos.model;

/**
 * Class for GeoJsonFeature structure ( with type, name, geometry and
 * properties).
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class GeoJsonFeature {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	/** The type. */
	private String type;

	/** The properties. */
	private GeoJsonProperties properties;

	/** The geometry. */
	private GeoJsonGeometry geometry;

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
	 * Gets the geo json properties.
	 *
	 * @return the geo json properties
	 */
	public GeoJsonProperties getGeoJsonProperties() {
		return properties;
	}

	/**
	 * Gets the geo json geometry.
	 *
	 * @return the geo json geometry
	 */
	public GeoJsonGeometry getGeoJsonGeometry() {
		return geometry;
	}

	// ****************************************
	// PUBLIC METHODS
	// ****************************************

	/**
	 * The Class GeoJsonGeometry.
	 */
	public static class GeoJsonGeometry {

		/** The type. */
		private String type;

		/** The coordinates. */
		private double[] coordinates;

		/**
		 * Instantiates a new geo json geometry.
		 *
		 * @param type
		 *            the type
		 * @param coordinates
		 *            the coordinates
		 */
		public GeoJsonGeometry(String type, double[] coordinates) {
			this.type = type;
			this.coordinates = coordinates;
		}

		/**
		 * Gets the type.
		 *
		 * @return the type
		 */
		public String getType() {
			return this.type;
		}

		/**
		 * Gets the coordinates.
		 *
		 * @return the coordinates
		 */
		public double[] getCoordinates() {
			return this.coordinates;
		}
	}

	/**
	 * The Class GeoJsonProperties.
	 */
	public static class GeoJsonProperties {

		/** The name. */
		private String name;

		/**
		 * Instantiates a new geo json properties.
		 *
		 * @param name
		 *            the name
		 */
		public GeoJsonProperties(String name) {
			this.name = name;
		}

		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public String getName() {
			return this.name;
		}
	}

	/**
	 * Instantiates a new geo json feature.
	 *
	 * @param type
	 *            the type
	 * @param geoJsonProperties
	 *            the geo json properties
	 * @param geometry
	 *            the geometry
	 */
	public GeoJsonFeature(String type, GeoJsonProperties geoJsonProperties, GeoJsonGeometry geometry) {
		this.type = type;
		this.properties = geoJsonProperties;
		this.geometry = geometry;
	}

	// ****************************************
	// PRIVATE METHODS
	// ****************************************

	// ****************************************
	// INNER CLASSES
	// ****************************************

	/**
	 * ({type":"FeatureCollection","features":[
	 * {"type":"Feature","properties":{"name":"Freiwillige Feuerwehr
	 * Sossenheim"}, "geometry":{"type":"Point","coordinates":[8.5689493
	 * (lon),50.1214732 (lat)]}},
	 */

}
