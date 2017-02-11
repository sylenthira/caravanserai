package org.caravanserai.demo.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Sylenthira on 2/11/2017.
 */
@Component
@Path("/hello")
public class HelloEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greetings() {
        return "Greetings from Spring Boot Jersey!";
    }
}
