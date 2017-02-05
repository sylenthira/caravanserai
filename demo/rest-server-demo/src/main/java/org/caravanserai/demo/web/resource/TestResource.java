package org.caravanserai.demo.web.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author sylenthira
 */
@Path("/test")
public class TestResource {

    private class Json {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        Json json = new Json();
        json.setName("Sylenthira!");
        return Response.status(Response.Status.OK).entity(json).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getHelloWord() {
        return Response.status(Response.Status.OK).entity("Hello World").build();
    }
}
