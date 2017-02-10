package org.caravanserai.demo.web.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author sylenthira
 */
public interface ContactResource {
    String CONTEXT_PATH = "contacts";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getContactsInJSON();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    Response getContactsInXML();
}
