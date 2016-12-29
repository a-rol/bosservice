package de.hs_mainz.BOS.Overpass_API;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import de.hs_mainz.BOS.Controller.OverpassAPI;
import de.hs_mainz.BOS.Model.Place;
import de.hs_mainz.BOS.Model.BOS;

@Path("Overpass_API")

public class RequestHandler {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get(@QueryParam("callback") String callback, @QueryParam("amenity") String amenity, @QueryParam("south") String south, @QueryParam("west") String west, @QueryParam("north") String north, @QueryParam("east") String east) throws NumberFormatException, UnsupportedEncodingException {
		System.out.println(callback);
		System.out.println(amenity);
		System.out.println(south);
		System.out.println(west);
		System.out.println(north);
		System.out.println(east);
		
		ArrayList<Place> allBOS = getRelevantBOS("fire_station",45.0,8.0,50.0,9.0);
		
		//ArrayList<Place> allBOS = getRelevantBOS(interest, Double.parseDouble(south), Double.parseDouble(west), Double.parseDouble(north), Double.parseDouble(east));
		ResponseHandler responseHandler = new ResponseHandler();
		String response = responseHandler.getResponse(allBOS);
		return response;
	}
	
	public String adCallback(String callback, String response) {
		if(callback.isEmpty() || callback == null)
			return response;
		else
			return callback + "'" + response + "'";
	}
	
	public ArrayList<Place> getRelevantBOS(String interest, Double south, Double west, Double north, Double east) throws UnsupportedEncodingException {
		BOS bos = new BOS();
		bos.setSouth(south);
		bos.setWest(west);
		bos.setNorth(north);
		bos.setEast(east);
		
		OverpassAPI OverpassAPI = new OverpassAPI();
		
		ArrayList<Place> allBOS = OverpassAPI.search(interest, bos);
		return allBOS;
	}
	
}
