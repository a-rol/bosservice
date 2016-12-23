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
 
//	http://143.93.114.138/api/isochrone?point=51.131108%2C12.414551&time_limit=300
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) 
    //@Produces(MediaType.TEXT_PLAIN)  
    
    //@QueryParam("lng") String lng, @QueryParam("lat") String lat, @QueryParam("time_min") String time_min
//    public String get(@QueryParam("queryJson") String queryJson) {
  public String get(String post){
    	
    	Gson gson = new Gson();        
        InputJSON InputJSON = gson.fromJson(post, InputJSON.class);
        String input = call_IsochroneAPI.URLConnectionReader(InputJSON);
    	
    	//return "\n Hello World!" + "\n"+ lng+ "\n"+ lat+ "\n"+ time_min +  "\n"+ input;
    	return "\n hallo " + input;
    }
}