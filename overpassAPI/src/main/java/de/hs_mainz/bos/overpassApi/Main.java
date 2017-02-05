package de.hs_mainz.bos.overpassApi;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main class of the microservice
 * 
 * @author Angelique
 * @since 28.12.2016
 */
public class Main {
	
    //****************************************
    // CONSTANTS
    //****************************************
	
	// URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8050/";
	
	@SuppressWarnings("deprecation")
	
    //****************************************
    // VARIABLES
    //****************************************
	
    //****************************************
    // INIT/CONSTRUCTOR
    //****************************************
	
	private Main() {
		
	}
	
    //****************************************
    // GETTER/SETTER
    //****************************************
	
    //****************************************
    // PUBLIC METHODS
    //****************************************
	
	/**
	 * Starts Grizzly HTTP server
	 * 
	 * @return Grizzly HTTP server
	 */
	
	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("de.hs_mainz.bos.overpassApi");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),rc);
	}
	
	/**
	 * Main server method
	 * 
	 * @param args 
	 * @throws IOException
	 */
	
	public static void main( String[] args) throws IOException {
		final HttpServer server = startServer();
		System.out.println(String.format("Jersery app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
		System.in.read();
		server.stop();
	}
	
    //****************************************
    // INNER CLASSES
    //****************************************
	
	/**
	 * example of a call
	 * localhost:8050/overpassAPI?callback=xxx&interest=fire_station&south=49.9221&west=8.0842&north=50.0972&east=8.4584
	 */
	
}
