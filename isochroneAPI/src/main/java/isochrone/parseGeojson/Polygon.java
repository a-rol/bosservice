package isochrone.parseGeojson;
/**
* Objektklasse des externen Rückgabewertes für Gson 
* @since 07.02.2017
* @author Thomas Müller
*/
import java.util.List;

public class Polygon {
	//****************************************
	// CONSTANTS 
	//****************************************

	//****************************************
	// VARIABLES
	//****************************************
	
	private String type;
	private List<FeatureList> features;		
	
	//****************************************
	// INIT/CONSTRUCTOR
	//****************************************
		
	//****************************************
	// GETTER/SETTER
	//****************************************
	
	public List<FeatureList> getFeature() {
        return features;
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
