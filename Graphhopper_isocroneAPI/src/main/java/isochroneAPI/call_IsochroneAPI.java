package isochroneAPI;


import isochroneAPI.ParseJSON.Input.InputJSON;
import isochroneAPI.ParseJSON.Input.Coordinate;
import isochroneAPI.ParseGEOJSON.IsochroneGEOJSON;
import isochroneAPI.ParseGEOJSON.Polygon;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.*;

public class call_IsochroneAPI {
	public static String URLConnectionReader(InputJSON InputJSON) {
		try{

	        
			//Variante für die Abfrage eines Polygone von der IsochroneAPI --> direkte Weitergabe
	        if (InputJSON.getCoordinates().size() == 1){
	        	
	        	List<String> UrlList = buildUrlList(InputJSON);
		        URL graphhopper = new URL(UrlList.get(0));
		        URLConnection gc = graphhopper.openConnection();
		        BufferedReader in = new BufferedReader(new InputStreamReader(gc.getInputStream()));
		        String inputLine;
		        String output = "";
		        while ((inputLine = in.readLine()) != null)
		        	output = inputLine;
		        in.close(); 
		        
		        return output;
	        	
	      	//Variante für die Abfrage mehrerer Polygone von der IsochroneAPI
	        }else if (InputJSON.getCoordinates().size() > 1){
	        	
		        List<IsochroneGEOJSON> GeoJsonObjList = new ArrayList<IsochroneGEOJSON>();
	        	List<String> UrlList = buildUrlList(InputJSON);
	        	Gson gson = new Gson();
	        	
		        for (int i = 0; i < UrlList.size(); i++){
		        	URL graphhopper = new URL(UrlList.get(0));
			        URLConnection gc = graphhopper.openConnection();
			        BufferedReader in = new BufferedReader(new InputStreamReader(gc.getInputStream()));		        	                
			        IsochroneGEOJSON IsochroneObj = gson.fromJson(in, IsochroneGEOJSON.class);
			        GeoJsonObjList.add(IsochroneObj);
		        }
		        //Zusammenführen der abgefragen Polygone in ein einziges GEOJSON
		        for (int i = 1; i < UrlList.size(); i++){
			        GeoJsonObjList.get(0).getPolygons().getFeature().add(GeoJsonObjList.get(i).getPolygons().getFeature().get(0));
		        }
		        //Umwandlung des Java-JsonObjektes in ein Json(String)
		        String geoJson = gson.toJson(GeoJsonObjList.get(0).getPolygons(), Polygon.class);
		        System.out.println(geoJson);
	        	return geoJson;
	        	
	        }
	        return "nothing";     
	        
		}catch (IOException e) {
				//event 
				e.printStackTrace();
			return "error";
		} 
	}

	//Erstellt Liste mit URL-Abfragen
	public static List<String> buildUrlList(InputJSON InputJSON){
		
		int time_limit = InputJSON.getTime_min() * 60;
		List<String> URLList = new ArrayList<String>();
		
		for (int  i=0; i < InputJSON.getCoordinates().size(); i++){
			double hochwert = InputJSON.getCoordinates().get(i).getLatitude();
			double rechtswert = InputJSON.getCoordinates().get(i).getLongitude();
			
			String URL = "http://143.93.114.138/api/isochrone?point="+ hochwert +"%2C"+ rechtswert +"&time_limit="+ time_limit;
			
			URLList.add(URL);
		}

		return URLList;
		/*
    	//Get API Key
    	String prop = "";
    	GetPropertyValue properties = new GetPropertyValue();
    	try {
			 prop = properties.getPropValues("offical_Isocrone_Key");
		} catch (IOException e) {
			//event 
			e.printStackTrace();
		}
		*/

	}
}