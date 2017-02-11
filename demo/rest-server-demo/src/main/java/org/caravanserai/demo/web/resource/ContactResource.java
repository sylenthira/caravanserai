package org.caravanserai.demo.web.resource;

import org.caravanserai.demo.dal.entity.Contact;
import org.caravanserai.demo.dal.entity.Phone;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
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
    Response getContactsInJSON(@QueryParam("start") Integer start,
                               @QueryParam("size") Integer size);

    @GET
    @Produces(MediaType.APPLICATION_XML)
    Response getContactsInXML(@QueryParam("start") Integer start,
                              @QueryParam("size") Integer size);

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Response getContactById(@PathParam("id") Integer id);

    @GET
    @Path("/contact")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    Response getContactByPhone(@QueryParam("phoneNo") String phoneNo);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response addContact(Contact contact);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response updateContact(@PathParam("id") Integer id, Contact contact);

    @DELETE
    @Path("/{id}")
    Response deleteContact(@PathParam("id") Integer id);

    @GET
    @Path("/{contactId}/phones")
    @Produces(MediaType.APPLICATION_JSON)
    Response getPhonesByContactId(@PathParam("contactId") Integer id);

    @GET
    @Path("/{contactId}/phones/{phoneId}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getPhoneByContactIdPhoneId(@PathParam("contactId") Integer contactId,
                                        @PathParam("phoneId") Integer phoneId);

    @POST
    @Path("/{contactId}/phones")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response addPhone(@PathParam("contactId") Integer contactId, Phone phone);

    @PUT
    @Path("/{contactId}/phones/{phoneId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response updatePhone(@PathParam("contactId") Integer contactId, @PathParam("phoneId") Integer phoneId, Phone phone);

    @DELETE
    @Path("/{contactId}/phones/{phoneId}")
    Response deletePhone(@PathParam("contactId") Integer contactId, @PathParam("phoneId") Integer phoneId);
}
