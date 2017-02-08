package org.caravanserai.demo.web.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sylenthira on 08/02/17.
 */
public interface ContactResource {
    String CONTEXT_PATH = "contacts";

    @GET
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getContacts();
}
