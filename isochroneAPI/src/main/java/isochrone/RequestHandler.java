package isochrone;
/**
* API Aufruf entgegennehmen, Auslesen der Abfrage aus POST-Parameter, Ausgabe des GeoJson (Polygone)
* @since 07.02.2017
* @author Thomas Müller
*/
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import isochrone.parseJson.input.InputJson;

@Path("isochrone")
public class RequestHandler {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
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
    * Stellt das Erreichbarkeitspolygon zur Verfügung
    * @param Post Parameter aus URL als Json
    * @return GeoJson mit den Ergebnispolygonenen der Abfrage
    * @throws 
    */
    public static String getParam(String post){
    	Gson gson = new Gson();        
        InputJson inputJson = gson.fromJson(post, InputJson.class);
        String output = CallIsochroneApi.URLConnectionReader(inputJson);
    	return output;
    }
    
	//****************************************
	// PRIVATE METHODS
	//****************************************

	//****************************************
	// INNER CLASSES
	//****************************************
}