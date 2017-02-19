package de.hsmainz.bos.overpassApi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import de.hsmainz.bos.controller.OverpassAPI;
import de.hsmainz.bos.model.BOS;
import de.hsmainz.bos.model.Place;

/**
 * class for adjusting the request for the overpass API.
 *
 * @author Angelique
 * @since 28.12.2016
 */

@Path("overpassAPI")

public class RequestHandler {

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
	 * @param callback
	 * @param interest
	 * @param south
	 * @param west
	 * @param north
	 * @param east
	 * @return the string
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get(@QueryParam("callback") String callback,
			@QueryParam("interest") String interest,
			@QueryParam("south") String south, @QueryParam("west") String west,
			@QueryParam("north") String north,
			@QueryParam("east") String east) {
		// System.out.println(callback);
		// System.out.println(interest);
		// System.out.println(south);
		// System.out.println(west);
		// System.out.println(north);
		// System.out.println(east);

		// ArrayList<Place> allBOS =
		// getRelevantBOS("fire_station",45.0,8.0,50.0,9.0);

		ArrayList<Place> allBOS = getRelevantBOS(interest,
				Double.parseDouble(south), Double.parseDouble(west),
				Double.parseDouble(north), Double.parseDouble(east));
		ResponseHandler responseHandler = new ResponseHandler();
		String response = responseHandler.getResponse(allBOS);
		return adCallback(callback, response);

	}

	/**
	 * Ad callback.
	 * 
	 * @param callback
	 * @param response
	 * @return callback response
	 */

	public String adCallback(String callback, String response) {
		if (callback.isEmpty() || callback == null)
			return response;
		else
			return callback + "('" + response + "')";
	}

	/**
	 * Gets the relevant BOS.
	 * 
	 * @param interest
	 * @param south
	 * @param west
	 * @param north
	 * @param east
	 * @return ArrayList of all BOS found in a given area (bbox with south,
	 *         west, north and east)
	 */

	public static ArrayList<Place> getRelevantBOS(String interest, Double south,
			Double west, Double north, Double east) {
		BOS bos = new BOS();
		bos.setInterest(interest);
		bos.setSouth(south);
		bos.setWest(west);
		bos.setNorth(north);
		bos.setEast(east);

		OverpassAPI OverpassAPI = new OverpassAPI();

		ArrayList<Place> allBOS = OverpassAPI.search(interest, bos);
		return allBOS;
	}

	// ****************************************
	// PRIVATE METHODS
	// ****************************************

	// ****************************************
	// INNER CLASSES
	// ****************************************

}
