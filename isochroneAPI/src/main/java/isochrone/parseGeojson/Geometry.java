package isochrone.parseGeojson;
/**
* Objektklasse des externen Rückgabewertes für Gson 
* @since 07.02.2017
* @author Thomas Müller
*/
import java.util.List;

public class Geometry {
	//****************************************
	// CONSTANTS 
	//****************************************

	//****************************************
	// VARIABLES
	//****************************************
	
	private String type;
	private List<List<List<Double>>> coordinates;	
	
	//****************************************
	// INIT/CONSTRUCTOR
	//****************************************
		
	//****************************************
	// GETTER/SETTER
	//****************************************
	
	public List<List<List<Double>>> getlatlng(){
		return coordinates;
	}
	public String getType(){
		return type;
	}	
	
	//****************************************
	// PUBLIC METHODS
	//****************************************
		
	//****************************************
	// PRIVATE METHODS
	//****************************************

	//****************************************
	// INNER CLASSES
	//****************************************
}
