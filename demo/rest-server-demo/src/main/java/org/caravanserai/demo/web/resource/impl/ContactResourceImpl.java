package org.caravanserai.demo.web.resource.impl;

import org.caravanserai.demo.service.ContactEntryService;
import org.caravanserai.demo.service.impl.ContactEntryServiceImpl;
import org.caravanserai.demo.web.resource.ContactResource;
import org.caravanserai.rest.server.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author sylenthira
 */
@Path(value = ContactResource.CONTEXT_PATH)
public class ContactResourceImpl implements ContactResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactResourceImpl.class);
    private static ContactEntryService contactEntryService;

    @PostConstruct
    void init() {
        if (contactEntryService == null) {
            contactEntryService = new ContactEntryServiceImpl();
        }
    }


    @Override
    public Response getContacts() {
        return ResponseUtil.getOkSuccess(contactEntryService.getContacts());
    }
}
