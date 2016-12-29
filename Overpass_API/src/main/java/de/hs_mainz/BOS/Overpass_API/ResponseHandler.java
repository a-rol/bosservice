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
			coordinates[1] = place.getGeometry().getLocation().getLat();
			coordinates[0] = place.getGeometry().getLocation().getLng();
			GeoJsonFeature currentFeature = new GeoJsonFeature("Feature", new GeoJsonProperties(place.getName()), new GeoJsonGeometry("Point", coordinates));
			features.add(currentFeature);
		}
		
		GeoJsonFeatureCollection featureCollection = new GeoJsonFeatureCollection("FeatureCollection", features);
		Gson gson = new Gson();
		String jsonInString = gson.toJson(featureCollection);
		
		return jsonInString;
	}

}
