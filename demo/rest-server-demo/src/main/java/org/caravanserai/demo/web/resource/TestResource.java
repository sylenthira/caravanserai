package org.caravanserai.demo.web.resource;

import org.caravanserai.demo.dto.Phone;
import org.caravanserai.demo.dto.jaxb.Phones;
import org.caravanserai.demo.dto.enums.PhoneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
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

    @GET
    @Path("/phones")
    @Produces(MediaType.APPLICATION_XML)
    public Response getPhone() {
        Phones phones = new Phones();
        phones.setPhoneList(new ArrayList<>());
        Phone phone;

        phone = new Phone();
        phone.setId(1);
        phone.setNumber("133422");
        phone.setType(PhoneType.HOME);
        phones.getPhoneList().add(phone);

        phone = new Phone();
        phone.setId(2);
        phone.setNumber("324323");
        phone.setType(PhoneType.MOBILE);
        phones.getPhoneList().add(phone);

        return Response.status(Response.Status.OK).entity(phones).build();
    }
}
