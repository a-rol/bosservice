package de.hs_mainz.BOS.Overpass_API;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import de.hs_mainz.BOS.Model.GeoJsonFeature;
import de.hs_mainz.BOS.Model.GeoJsonFeature.GeoJsonGeometry;
import de.hs_mainz.BOS.Model.GeoJsonFeature.GeoJsonProperties;
import de.hs_mainz.BOS.Model.GeoJsonFeatureCollection;
import de.hs_mainz.BOS.Model.Place;

public class ResponseHandler {
	
	public String getResponse(ArrayList<Place> allBOS) {
		
		List<GeoJsonFeature> features = new ArrayList<GeoJsonFeature>();
		for (Place place : allBOS) {
			//set Coordinates for GeoJsonGeometry
			double[] coordinates = new double[2];
			coordinates[1] = place.getLat();
			coordinates[0] = place.getLon();
			GeoJsonFeature currentFeature = new GeoJsonFeature("Feature", new GeoJsonProperties(place.getTags().getName()), new GeoJsonGeometry("Point", coordinates));
			features.add(currentFeature);
		}
		
		GeoJsonFeatureCollection featureCollection = new GeoJsonFeatureCollection("FeatureCollection", features);
		Gson gson = new Gson();
		String jsonInString = gson.toJson(featureCollection);
		
		return jsonInString;
		/*
		 * {
		 * "version":0.6,
		 * "generator":"Overpass API",
		 * "osm3s":{
		 * "timestamp_om_base":"2016-12-29T12:30:03Z","copyright":"The data included in this document is from www.openstreetmap.org. The data is made available under ODbL."},
		 * "elements":[
		 * {
		 * "type":"node",
		 * "id": 32468124,
		 * "lat": 50.1214732,
		 * "lon": 8.5689493,
		 * "tags":{
		 * 	"amenity":"fire_station",
		 * 	"name":"Freiwillige Feuerwehr Sossenheim"
		 * }
		 * },
		 * 
		 * }
		 */
		
		/*
		 * GEO JSON ARNO
		 * ({"type":"FeatureCollection",
		 * "features":[
		 * {...}]})
		 */
		
		/*
		 * ({type":"FeatureCollection","features":[
		 * {"type":"Feature","properties":{"name":"Freiwillige Feuerwehr Sossenheim"},
		 * "geometry":{"type":"Point","coordinates":[8.5689493 (lon),50.1214732 (lat)]}},
		 */
	}

}
