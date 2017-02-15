package isochrone;
/**
* Klasse, welche die Abfrage an die externe Graphhopper Isochrone API realisiert und das Ergebnis in ein Geojson umwandelt
* @since 07.02.2017
* @author Thomas Müller
*/
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import isochrone.parseGeojson.IsochroneGeojson;
import isochrone.parseGeojson.Polygon;
import isochrone.parseJson.input.InputJson;
import java.io.*;

public class CallIsochroneApi {
	//****************************************
	// CONSTANTS 
	//****************************************

	//****************************************
	// VARIABLES
	//****************************************
			
	//****************************************
	// INIT/CONSTRUCTOR
	//****************************************
		
	//****************************************
	// GETTER/SETTER
	//****************************************
		
	//****************************************
	// PUBLIC METHODS
	//****************************************
	/**
    * Ruft den Graphhopper Isochrone Services auf und bereitet die Daten für den MS auf
    * @param inputJson Klasse mit den Abfrageparametern
    * @return Uri for geocoder request on graphhopper API
    * @throws 
    */
	public static String URLConnectionReader(InputJson inputJson) {
		try{
			if (inputJson.getCoordinates().size() >= 1){ 	
		        List<IsochroneGeojson> geoJsonObjList = new ArrayList<IsochroneGeojson>();
	        	List<String> urlList = buildUrlList(inputJson);
	        	// Gson notwendig da die Oberste Objektebene des zurückgegebenen JSON von der API nicht zu einem GEOJSON gehört
	        	Gson gson = new Gson();
	        	
	        	// Iteration durch die UrlListe und Umwandlung des Abfrageergebnisses in java Objekt
		        for (int i = 0; i < urlList.size(); i++){
		        	URL graphhopper = new URL(urlList.get(i));
			        URLConnection gc = graphhopper.openConnection();
			        BufferedReader in = new BufferedReader(new InputStreamReader(gc.getInputStream()));		        	                
			        IsochroneGeojson isochroneObj = gson.fromJson(in, IsochroneGeojson.class);
			        geoJsonObjList.add(isochroneObj);
		        }
		        //Zusammenführen der abgefragen Polygone in ein einziges GEOJSON
		        for (int i = 1; i < urlList.size(); i++){
			        geoJsonObjList.get(0).getPolygons().getFeature().add(geoJsonObjList.get(i).getPolygons().getFeature().get(0));
		        }
		        //Umwandlung des Java-JsonObjektes in ein Json(String)
		        String geoJson = gson.toJson(geoJsonObjList.get(0).getPolygons(), Polygon.class);		        
	        	return geoJson;        	
	        }else{
	        return "nothing";
	        }
		}catch (IOException e) {
				//event 
				e.printStackTrace();
			return "error";
		} 
	}
	
    /**
    * Erstellt Liste mit URL-Abfragen
    * @param inputJson Klasse mit den Abfrageparametern
    * @return Liste mit einzelnen URL-Abfragen
    * @throws 
    */
	public static List<String> buildUrlList(InputJson inputJson){		
		int timeLimit = inputJson.getTimeMin() * 60;
		List<String> urlList = new ArrayList<String>();
		
		for (int  i=0; i < inputJson.getCoordinates().size(); i++){
			double hochwert = inputJson.getCoordinates().get(i).getLatitude();
			double rechtswert = inputJson.getCoordinates().get(i).getLongitude();
			
			String URL = "http://143.93.114.138/api/isochrone?point="+ hochwert +"%2C"+ rechtswert +"&time_limit="+ timeLimit;		
			urlList.add(URL);
		}
		return urlList;
	}	
	//****************************************
	// PRIVATE METHODS
	//****************************************

	//****************************************
	// INNER CLASSES
	//****************************************
}