package isochroneAPI;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class CORS_Filter implements ContainerResponseFilter {
	public ContainerResponse filter(ContainerRequest req, ContainerResponse ContainerResponse) {
		 
        ResponseBuilder ResponseBuilder = Response.fromResponse(ContainerResponse.getResponse());
        
        // *(allow from all servers) OR http://crunchify.com/ OR http://example.com/
        ResponseBuilder.header("Access-Control-Allow-Origin", "*")
        
        // As a part of the response to a request, which HTTP methods can be used during the actual request.
        .header("Access-Control-Allow-Methods", "API, CRUNCHIFYGET, GET, POST, PUT, UPDATE, OPTIONS")
        
        // How long the results of a request can be cached in a result cache.
        .header("Access-Control-Max-Age", "151200")
        
        // As part of the response to a request, which HTTP headers can be used during the actual request.
        .header("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
 
        String RequestHeader = req.getHeaderValue("Access-Control-Request-Headers");
 
        if (null != RequestHeader && !RequestHeader.equals(null)) {
            ResponseBuilder.header("Access-Control-Allow-Headers", RequestHeader);
        }
 
        ContainerResponse.setResponse(ResponseBuilder.build());
        return ContainerResponse;
    }
}
