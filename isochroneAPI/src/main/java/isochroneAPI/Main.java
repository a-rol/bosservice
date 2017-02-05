package isochroneAPI;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import javax.ws.rs.core.UriBuilder;
 
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class Main {
 
    public static void main(String[] args) throws IOException {
        System.out.println("Starting HTTPServer...\n");
        HttpServer HTTPServer = createHttpServer();

        HTTPServer.start();
        System.out.println(String.format("\nJersey Application Server started with WADL available at " + "%sapplication.wadl\n", getURI()));
        System.out.println("Started Embedded Jersey HTTPServer Successfully !!!");
    }
 
    private static HttpServer createHttpServer() throws IOException {
        ResourceConfig resourceConfig = new PackagesResourceConfig("isochroneAPI");
        resourceConfig.getContainerResponseFilters().add(CORS_Filter.class);
        return HttpServerFactory.create(getURI(), resourceConfig);
    }
 
    private static URI getURI() {
    	//local Version
        return UriBuilder.fromUri("http://localhost/").port(8085).build();
    }
 
}