package isochroneAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import isochroneAPI.GetPropertyValue;

import java.io.IOException;
import java.io.InputStreamReader;

@Path("api")
public class RequestHandler {
 
//	http://143.93.114.138/api/isochrone?point=51.131108%2C12.414551&time_limit=300
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)  
    
    //@QueryParam("lng") String lng, @QueryParam("lat") String lat, @QueryParam("time_min") String time_min
    public String get(@QueryParam("queryJson") String queryJson) {
    	
    	//String input = call_IsochroneAPI.URLConnectionReader(lng, lat, time_min);
    	String input = queryJson;
    	//return anything
    	//String test = request.getParameter("test");
    	//return "\n Hello World!" + "\n"+ lng+ "\n"+ lat+ "\n"+ time_min +  "\n"+ input;
    	return input;
    }
}