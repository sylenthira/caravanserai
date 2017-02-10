package org.caravanserai.demo.web.resource.test;

import org.caravanserai.demo.web.jaxb.dto.JaxbPhone;
import org.caravanserai.demo.web.jaxb.dto.Phones;
import org.caravanserai.demo.dal.entity.enums.PhoneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * @author sylenthira
 */
@Path("/test")
public class TestResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestResource.class);

    @PostConstruct
    void init(){
        LOGGER.info("Inside Init");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getHelloWord() {
        return Response.status(Response.Status.OK).entity("Hello World").build();
    }

    @GET
    @Path("/phones")
    @Produces(MediaType.APPLICATION_XML)
    public Response getPhone() {
        Phones phones = new Phones();
        phones.setPhoneList(new ArrayList<>());
        JaxbPhone phone;

        phone = new JaxbPhone();
        phone.setId(1);
        phone.setNumber("133422");
        phone.setType(PhoneType.HOME);
        phones.getPhoneList().add(phone);

        phone = new JaxbPhone();
        phone.setId(2);
        phone.setNumber("324323");
        phone.setType(PhoneType.MOBILE);
        phones.getPhoneList().add(phone);

        return Response.status(Response.Status.OK).entity(phones).build();
    }
}
