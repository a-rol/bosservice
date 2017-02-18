package de.hsmainz.bos.overpassApi;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import de.hsmainz.bos.model.GeoJsonFeature;
import de.hsmainz.bos.model.GeoJsonFeature.GeoJsonGeometry;
import de.hsmainz.bos.model.GeoJsonFeature.GeoJsonProperties;
import de.hsmainz.bos.model.GeoJsonFeatureCollection;
import de.hsmainz.bos.model.Place;

/**
 * class for handling the response of the overpass API from OSM.
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class ResponseHandler {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	// ****************************************
	// INIT/CONSTRUCTOR
	// ****************************************

	// ****************************************
	// GETTER/SETTER
	// ****************************************

	// ****************************************
	// PUBLIC METHODS
	// ****************************************

	/**
	 * Gets the response.
	 *
	 * @param allBOS
	 *            the all BOS
	 * @return jsonInString -> allBOS in a String
	 */

	public static String getResponse(ArrayList<Place> allBOS) {

		List<GeoJsonFeature> features = new ArrayList<GeoJsonFeature>();
		for (Place place : allBOS) {
			// set Coordinates for GeoJsonGeometry
			double[] coordinates = new double[2];
			coordinates[1] = place.getLat();
			coordinates[0] = place.getLon();
			GeoJsonFeature currentFeature = new GeoJsonFeature("Feature",
					new GeoJsonProperties(place.getTags().getName()), new GeoJsonGeometry("Point", coordinates));
			features.add(currentFeature);
		}

		GeoJsonFeatureCollection featureCollection = new GeoJsonFeatureCollection("FeatureCollection", features);
		Gson gson = new Gson();
		String jsonInString = gson.toJson(featureCollection);

		return jsonInString;
		/**
		 * Example of a response from the Overpass API { "version":0.6,
		 * "generator":"Overpass API", "osm3s":{
		 * "timestamp_om_base":"2016-12-29T12:30:03Z","copyright":"The data
		 * included in this document is from www.openstreetmap.org. The data is
		 * made available under ODbL."}, "elements":[ { "type":"node", "id":
		 * 32468124, "lat": 50.1214732, "lon": 8.5689493, "tags":{
		 * "amenity":"fire_station", "name":"Freiwillige Feuerwehr Sossenheim" }
		 * },
		 * 
		 * }
		 */

		/**
		 * GEO JSON ARNO ({"type":"FeatureCollection", "features":[ {...}]})
		 */

		/**
		 * ({type":"FeatureCollection","features":[
		 * {"type":"Feature","properties":{"name":"Freiwillige Feuerwehr
		 * Sossenheim"}, "geometry":{"type":"Point","coordinates":[8.5689493
		 * (lon),50.1214732 (lat)]}},
		 */
	}

	// ****************************************
	// PRIVATE METHODS
	// ****************************************

	// ****************************************
	// INNER CLASSES
	// ****************************************

}
