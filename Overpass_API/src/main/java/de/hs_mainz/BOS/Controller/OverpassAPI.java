package de.hs_mainz.BOS.Controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.Gson;

import de.hs_mainz.BOS.Model.*;

public class OverpassAPI {
	
	private static final String LOG_TAG = "BOS_OverpassAPI ";
	
	private static final String PLACES_API_BASE ="http://overpass-api.de/api/interpreter?data=[out:json];";
	
	public static ArrayList<Place> search(String keyword, BOS bos) throws UnsupportedEncodingException {
		
		String requestStart = buildRequest(keyword, bos);
		
		InputStreamReader in = null;
		in = postQuery(requestStart, in);
		
		PlacesResult placesResult = new Gson().fromJson(in, PlacesResult.class);
		ArrayList<Place> places = (ArrayList<Place>) placesResult.getList();
		
		if (places.isEmpty()) {
			System.out.println("No BOS found");
		} else {
			for (Place place : places) {
				System.out.println(place.getName());
			}
		}
		
		return places;
	}

	public static String buildRequest(String keyword, BOS bos) throws UnsupportedEncodingException {
		String requestUri = "";
		String bbox = String.valueOf(bos.getSouth()) + "," + String.valueOf(bos.getWest()) + "," + String.valueOf(bos.getNorth()) + "," + String.valueOf(bos.getEast());
		StringBuilder sb = new StringBuilder(PLACES_API_BASE);
		sb.append("node(" + bbox + ")[amenity=" + keyword + "];out;");
		
		requestUri = sb.toString();
		System.out.println(requestUri);
		
		return requestUri;
		
	}

	public static InputStreamReader postQuery(String request, InputStreamReader in) {
	
		URL url = null;
		HttpURLConnection conn;
		try{
			url = new URL(request);
			conn = (HttpURLConnection) url.openConnection();
			in = new InputStreamReader(conn.getInputStream());
		}catch (MalformedURLException e) {
			System.out.println(LOG_TAG + "Error processing Places API URL" + e);
			e.printStackTrace();
		}catch (IOException e){
			System.out.println(LOG_TAG + "Error connecting to Places API" + e);
			e.printStackTrace();
		}
		
		System.out.println(in.toString());
		return in;
	}
}
