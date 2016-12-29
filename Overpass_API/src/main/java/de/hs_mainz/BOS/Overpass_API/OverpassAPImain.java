package de.hs_mainz.BOS.Overpass_API;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Hello world!
 *
 */
public class OverpassAPImain 
{
	public static final String BASE_URI = "http://localhost:8097/";
	
	@SuppressWarnings("deprecation")
	public static void main( String[] args) throws IOException {
		final HttpServer server = startServer();
		System.out.println(String.format("Jersery app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
		System.in.read();
		server.stop();
	}
	
	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig().packages("de.hs_mainz.BOS.Overpass_API");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),rc);
	}
	
	//Beispiel Aufruf
	//localhost:8088/Overpass_API/callback=xxx&interest=fire_station&south=49.9221&west=8.0842&north=50.0972&east=8.4584
	
}
