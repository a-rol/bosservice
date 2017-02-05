package isochroneAPI;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import isochroneAPI.GetPropertyValue;
import isochroneAPI.ParseJSON.Input.InputJSON;

import java.io.IOException;
import java.io.InputStreamReader;

@Path("isochrone")
public class RequestHandler {
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
  public String get(String post){
    	
    	Gson gson = new Gson();        
        InputJSON InputJSON = gson.fromJson(post, InputJSON.class);
        String input = call_IsochroneAPI.URLConnectionReader(InputJSON);
    	return input;
    }
}