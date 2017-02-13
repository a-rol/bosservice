package de.hsmainz.bos.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

import de.hsmainz.bos.model.BOS;
import de.hsmainz.bos.model.Place;
import de.hsmainz.bos.model.PlacesResult;

/**
 * The Class OverpassAPI.
 *
 * @author Angelique
 * @since 28.12.2016
 */

public class OverpassAPI {

	// ****************************************
	// CONSTANTS
	// ****************************************

	// ****************************************
	// VARIABLES
	// ****************************************

	private static final String LOG_TAG = "BOS_OverpassAPI ";

	private static final String PLACES_API_BASE = "http://overpass-api.de/api/interpreter?data=[out:json];";

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
	 * Search.
	 *
	 * @param keyword
	 *            bos
	 * @param bos
	 *            the bos
	 * @return places
	 */

	public ArrayList<Place> search(String keyword, BOS bos) {

		String requestStart = buildRequest(keyword, bos);

		InputStreamReader in = null;
		in = postQuery(requestStart, in);

		PlacesResult placesResult = new Gson().fromJson(in, PlacesResult.class);
		ArrayList<Place> places = (ArrayList<Place>) placesResult.getList();

		if (places.isEmpty()) {
			System.out.println("No BOS found");
		} else {
			for (Place place : places) {
				System.out.println(place.getId());
				System.out.println(place.getLat());
				System.out.println(place.getLon());
				System.out.println(place.getTags().getName());
			}
		}

		return places;
	}

	/**
	 * Builds the request.
	 *
	 * @param keyword
	 *            bos
	 * @param bos
	 *            the bos
	 * @return requestUri
	 */

	public String buildRequest(String keyword, BOS bos) {
		String requestUri = "";
		String bbox = String.valueOf(bos.getSouth()) + "," + String.valueOf(bos.getWest()) + ","
				+ String.valueOf(bos.getNorth()) + "," + String.valueOf(bos.getEast());
		StringBuilder sb = new StringBuilder(PLACES_API_BASE);
		sb.append("node(" + bbox + ")[amenity=" + keyword + "];out;");

		requestUri = sb.toString();
		System.out.println(requestUri);

		return requestUri;

	}

	/**
	 * Post query.
	 *
	 * @param request
	 *            in
	 * @param in
	 *            the in
	 * @return in
	 */

	public InputStreamReader postQuery(String request, InputStreamReader in) {

		URL url = null;
		HttpURLConnection conn;
		try {
			url = new URL(request);
			conn = (HttpURLConnection) url.openConnection();
			in = new InputStreamReader(conn.getInputStream());
		} catch (MalformedURLException e) {
			System.out.println(LOG_TAG + "Error processing Places API URL" + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(LOG_TAG + "Error connecting to Places API" + e);
			e.printStackTrace();
		}

		System.out.println(in.toString());
		return in;
	}

	// ****************************************
	// PRIVATE METHODS
	// ****************************************

	// ****************************************
	// INNER CLASSES
	// ****************************************

}
