package isochrone;
/**
* Start des HttpServers
* @since 07.02.2017
* @author Thomas Müller
*/
import java.io.IOException;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class Main {
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
    * Hauptmethode des Servers
    * @param args Einstellungen
    * @throws IOException
    */
	 public static void main(String[] args) throws IOException {
		 System.out.println("Starting HTTPServer...\n");
	     HttpServer HTTPServer = createHttpServer();

	     HTTPServer.start();
	     System.out.println(String.format("\nJersey Application Server started with WADL available at " + "%sapplication.wadl\n", getURI()));
	     System.out.println("Started Embedded Jersey HTTPServer Successfully !!!");
	 }	
	//****************************************
	// PRIVATE METHODS
	//****************************************
	/**
	* Startet den Server
	* @return ServerInstanz
	* @throws IOException
	*/
	private static HttpServer createHttpServer() throws IOException {
	    ResourceConfig resourceConfig = new PackagesResourceConfig("isochrone");
	    resourceConfig.getContainerResponseFilters().add(CorsFilter.class);
	    return HttpServerFactory.create(getURI(), resourceConfig);
	}
	/**
	* Startet den Server
	* @return Uri
	*/    
	private static URI getURI() {
	    return UriBuilder.fromUri("http://localhost/").port(8085).build();
	}
	//****************************************
	// INNER CLASSES
	//****************************************
}