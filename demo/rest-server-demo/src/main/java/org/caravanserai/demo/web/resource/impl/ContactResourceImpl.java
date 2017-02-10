package org.caravanserai.demo.web.resource.impl;

import org.caravanserai.demo.dal.entity.Contact;
import org.caravanserai.demo.web.jaxb.dto.Contacts;
import org.caravanserai.demo.web.jaxb.dto.JaxbContact;
import org.caravanserai.demo.web.jaxb.dto.JaxbPhone;
import org.caravanserai.demo.web.jaxb.dto.Phones;
import org.caravanserai.demo.service.ContactEntryService;
import org.caravanserai.demo.service.impl.ContactEntryServiceImpl;
import org.caravanserai.demo.web.resource.ContactResource;
import org.caravanserai.rest.server.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

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
    public Response getContactsInJSON() {
        return ResponseUtil.getOkSuccess(contactEntryService.getContacts());
    }

    @Override
    public Response getContactsInXML() {
        List<Contact> contactList = contactEntryService.getContacts();

        Contacts contacts = null;
        if (contactList != null && contactList.size() > 0) {
            contacts = new Contacts();
            List<JaxbContact> jaxbContacts = new ArrayList<>();
            contactList.forEach(c -> {
                JaxbContact jaxbContact = new JaxbContact();
                jaxbContact.setId(c.getId());
                jaxbContact.setName(c.getName());
                if (c.getPhones() != null && c.getPhones().size() > 0) {
                    Phones phones = new Phones();
                    phones.setPhoneList(new ArrayList<>());
                    c.getPhones().forEach(p-> {
                        JaxbPhone jaxbPhone = new JaxbPhone();
                        jaxbPhone.setId(p.getId());
                        jaxbPhone.setNumber(p.getNumber());
                        jaxbPhone.setType(p.getType());
                        phones.getPhoneList().add(jaxbPhone);
                    });
                    jaxbContact.setPhones(phones);
                }
                jaxbContacts.add(jaxbContact);
            });
            contacts.setContactList(jaxbContacts);
        }

        return ResponseUtil.getOkSuccess(contacts);
    }
}
