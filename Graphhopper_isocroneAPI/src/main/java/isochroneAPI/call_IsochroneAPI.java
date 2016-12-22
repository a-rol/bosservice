package isochroneAPI;


import isochroneAPI.ParseJSON.*;
import java.net.*;
import com.google.gson.Gson;
import java.io.*;

public class call_IsochroneAPI {


	public static String URLConnectionReader(String lng, String lat, String time_min ) {
		try{
	        URL graphhopper = new URL(buildURL(lng , lat, time_min));
	        URLConnection gc = graphhopper.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(gc.getInputStream()));
	        
	        //Test1
	        //InputStreamReader in = new InputStreamReader(gc.getInputStream());
	        //next step give "in" Object to gson
	        //return in;
	        
	        //Gson gson = new Gson();        
	        	        
	        //IsochroneJSON IsochroneObj = gson.fromJson(in, IsochroneJSON.class);
	        //System.out.println(IsochroneObj.getPolygons().get(1).getGeometry().getpoint().get(1).getLatitude());
	        
	        String inputLine;
	        String output = "";
	        while ((inputLine = in.readLine()) != null)
	        	output = inputLine;
	            System.out.println(inputLine);
	        in.close(); 
	        
	        return output;
	        
		}catch (IOException e) {
				//event 
				e.printStackTrace();
			return null;
		} 
	}
	
	public static String buildURL(String lng, String lat, String time_min ){
		//test json call from user
			//{"time_limit_min":"5","point":{"HW":"50","RW":"12"}}
	
		
		String hochwert = lat;
		String rechtswert = lng;
		int time_limit = Integer.parseInt(time_min) * 60;
		
    	//Get API Key
    	String prop = "";
    	GetPropertyValue properties = new GetPropertyValue();
    	try {
			 prop = properties.getPropValues("offical_Isocrone_Key");
		} catch (IOException e) {
			//event 
			e.printStackTrace();
		}
		
		String APIKey = prop;
		String URL = "http://143.93.114.138/api/isochrone?point="+ hochwert +"%2C"+ rechtswert +"&time_limit="+ time_limit;
		return URL;
	}
}